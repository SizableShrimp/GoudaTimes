import mysql.connector
import pickle as pkl
import json
import os
import hashlib
from dataclasses import asdict

from article import ArticleNPK

from actually_hash import actually_hash

class ArticlesDb:
    def __init__(self, already_processed_filename: str):
        self.already_processed_filename = already_processed_filename
        self.sync_already()
        self.cnx = mysql.connector.connect(
            user="chez", password=os.getenv("CHEZ_MYSQL_PASSWORD"),
            host="net.tsuni.dev", port=52355,
            database="db",
        )

    def cleanup(self):
        self.sync_already()
        self.cnx.close()

    def sync_already(self):
        if "already" in self.__dict__:
            with open(self.already_processed_filename, "wb") as f:
                pkl.dump(self.already, f)
        else:
            try:
                with open(self.already_processed_filename, "rb") as f:
                    self.already = pkl.load(f)
            except:
                with open(self.already_processed_filename, "wb") as f:
                    print("Clearing already processed file.")
                    pkl.dump(set(), f)
                self.already = set()

    def add_article(self, article_orig: ArticleNPK, ref: str = "?", recreate: bool = False):
        article = ArticleNPK(**asdict(article_orig))
        orighash = actually_hash(article.original_url)
        if orighash in self.already and not recreate:
            print(f"<already processed article {ref}>")
            return
        print(f"~> Cheesifying \"{article.title}\"...", end="", flush=True)
        article.cheesify()
        print("done.")
        print(f"~> Adding \"{article.title}\" to db...", end="", flush=True)
        self.add_article_unchecked(article)
        print("done.")
        print(f"~> Synchronizing list of already-processed articles...", end="", flush=True)
        self.already.add(orighash)
        self.sync_already()
        print(f"~> Done processing article {ref}.")

    def add_article_unchecked(self, article: ArticleNPK):
        cursor = self.cnx.cursor()
        cursor.execute(
            """
            INSERT INTO Articles
            (
                Title, DateWritten, ByLine, HeaderImageUrl, HeaderImageAttribution,
                SourceDomain, SortedCategoriesJson, OriginalUrl, Content
            )
            VALUES (
                %s,    %s,          %s,     %s,             %s,
                %s,           %s,                   %s,          %s
            )
            """.strip(),
            (
                article.title, article.date_written, article.by_line, article.header_image_url,
                article.header_image_attribution, article.source_domain,
                json.dumps(article.sorted_categories),
                article.original_url, article.content,
            ),
        )
        self.cnx.commit()
        cursor.close()

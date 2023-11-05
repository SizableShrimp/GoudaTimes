import mysql.connector
import pickle as pkl
import json

from article import ArticleNPK

class ArticlesDb:
    def __init__(self, already_processed_filename: str):
        self.already_processed_filename = already_processed_filename
        self.sync_already()
        self.cnx = mysql.connector.connect(
            user="chez", password=os.getenv("CHEZ_MYSQL_PASSWORD"),
            host="net.tsuni.dev", port=52355,
            database="db",
        )
        self.cursor = self.cnx.cursor()
    
    def regenerate_cursor(self):
        self.cnx.commit()
        self.cursor.close()
        self.cursor = self.cnx.cursor()

    def cleanup(self):
        self.sync_already()
        self.cursor.close()
        self.cnx.close()

    def sync_already(self):
        if "already" in self.__dict__:
            with open(self.already_processed_filename, "wb") as f:
                pkl.dump(self.already, f)
        else:
            with open(self.already_processed_filename, "rb") as f:
                self.already = pkl.load(f)

    def add_article(self, article: ArticleNPK, recreate: bool = False):
        orighash = hash(article.original_url)
        if orighash in self.already and not recreate:
            return
        self.add_article_unchecked(article)
        self.already.append(orighash)

    def add_article_unchecked(self, article: ArticleNPK):
        self.cursor.execute(
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
                article.title, article.date_written, article.header_image_url,
                article.header_image_attribution, article.source_domain,
                json.dumps(article.sorted_categories),
                article.original_url, article.content,
            ),
        )

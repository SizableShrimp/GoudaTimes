import pickle as pkl

from article import ArticleNPK

class ArticlesDb:
    def __init__(self, already_processed_filename: str):
        self.already_processed_filename = already_processed_filename
        self.sync_already()
    
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
        

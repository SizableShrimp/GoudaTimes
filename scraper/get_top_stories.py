import requests as req
import os

from article import ArticleNPK

nyt_api_key = os.environ["NYT_DEV_API_KEY"]

def get_top_stories() -> list[ArticleNPK]:
    resp = req.get(f"https://api.nytimes.com/svc/topstories/v2/home.json?api-key={nyt_api_key}")
    assert resp.status_code == 200
    ret = []
    for result in resp.json()["results"]:
        if result["item_type"] != "Article":
            continue
        ret.append(ArticleNPK(
            result["title"],
            result["abstract"],
            result["published_date"][:10],
            result["byline"],
            result["multimedia"][0]["url"],
        ))
    return ret

if __name__ == "__main__":
    print(get_top_stories())

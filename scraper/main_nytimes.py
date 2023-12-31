import requests as req
import os

from article import ArticleNPK
from articles_db import ArticlesDb

nyt_api_key = os.environ["NYT_DEV_API_KEY"]

nytimes_facet_names = {
    "des_facet": "description",
    "org_facet": "organization",
    "per_facet": "person",
    "geo_facet": "location",
}

def get_top_stories() -> list[ArticleNPK]:
    resp = req.get(f"https://api.nytimes.com/svc/topstories/v2/home.json?api-key={nyt_api_key}")
    assert resp.status_code == 200
    ret = []
    for result in resp.json()["results"]:
        if result["item_type"] != "Article":
            continue
        if result["byline"] == "":
            continue
        has_image  = (len(result["multimedia"]) > 0)
        has_image &= (result["multimedia"][0]["copyright"] != "")
        ret.append(ArticleNPK(
            result["title"],
            result["abstract"],
            result["published_date"][:10],
            result["byline"],
            result["multimedia"][0]["url"]       if has_image else None,
            result["multimedia"][0]["copyright"] if has_image else None,
            "nytimes.com",
            {
                nytimes_facet_names[k]: v
                for k, v in result.items()
                if k.endswith("_facet") and (k in nytimes_facet_names)
            },
            result["url"],
            "<< not yet generated >>",
        ))
    # simple hack to only generate 2 articles each run
    return ret[0:2]

if __name__ == "__main__":
    print("~> Setting up database connection...", end="", flush=True)
    db = ArticlesDb("already_processed.pkl")
    print("done.")
    print("~> Loading top stories...", end="", flush=True)
    top_stories = get_top_stories()
    print("done.")
    for i, article in enumerate(top_stories):
        try:
            print(f"~> Processing article {i+1}/{len(top_stories)}.")
            db.add_article(article, f"{i+1}/{len(top_stories)}")
        except Exception as e:
            print(e)
            print("~> /!\\ Failed /!\\")
    print(f"~> Cleaning up database connection...", end="", flush=True)
    db.cleanup()
    print("done.")

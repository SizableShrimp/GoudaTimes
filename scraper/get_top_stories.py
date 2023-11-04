import requests as req
import os

from article import ArticleNPK

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
            "<< not yet generated >>",
        ))
    return ret

if __name__ == "__main__":
    print(get_top_stories())

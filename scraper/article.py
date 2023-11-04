from dataclasses import dataclass

@dataclass
class ArticleNPK: # NPK = No Primary Key, See database schema
    title: str
    nofield_abstract: str # Does not appear in the database, just to give the AI more context
    date_written: str | None
    by_line: str
    header_image_url: str | None
    header_image_attribution: str | None
    source_domain: str
    sorted_categories: dict[str, list[str]]
    content: str # Can be "<< not yet generated >>"

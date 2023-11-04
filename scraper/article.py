from dataclasses import dataclass

@dataclass
class ArticleNPK: # NPK = No Primary Key, See database schema
    title: str
    nofield_abstract: str # Does not appear in the database, just to give the AI more context
    date_written: str
    by_line: str
    header_image_url: str
    source_domain: str
    sorted_categories: dict[str, list[str]]
    content: str

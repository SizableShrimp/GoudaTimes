from dataclasses import dataclass

@dataclass
class ArticleNPK: # NPK = No Primary Key
    title: str
    date_written: str
    by_line: str
    header_image_url: str
    source_domain: str
    sorted_categories: dict[str, list[str]]
    content: str

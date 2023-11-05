CREATE DATABASE IF NOT EXISTS db;
USE db;
CREATE TABLE IF NOT EXISTS Articles (
	Id INT NOT NULL AUTO_INCREMENT,
	Title TEXT NOT NULL,
	DateWritten VARCHAR(10), -- Use format 2023-11-04
	ByLine TEXT NOT NULL, -- ex. By John Doe
	HeaderImageUrl TEXT,
	HeaderImageAttribution TEXT, -- Copyright for image
	SourceDomain VARCHAR(63) NOT NULL, -- Not the API domain, ex. nytimes.com
	SortedCategoriesJson TEXT NOT NULL, -- ex. {"person": [<name>, ...]}
	OriginalUrl TEXT NOT NULL,
	Content TEXT NOT NULL,
	PRIMARY KEY (Id)
);
CREATE TABLE IF NOT EXISTS BannedArticles (
	Id INT NOT NULL AUTO_INCREMENT,
	BannedId INT NOT NULL,
	PRIMARY KEY (Id)
);
INSERT IGNORE INTO BannedArticles VALUES (1, -1);

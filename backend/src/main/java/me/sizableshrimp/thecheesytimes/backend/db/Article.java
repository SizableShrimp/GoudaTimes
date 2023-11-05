package me.sizableshrimp.thecheesytimes.backend.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "Articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Title", columnDefinition = "TEXT")
    private String title;

    @Column(name = "DateWritten", length = 10)
    private String dateWritten;

    @Column(name = "ByLine", columnDefinition = "TEXT")
    private String byLine;

    @Column(name = "HeaderImageUrl", columnDefinition = "TEXT")
    private String headerImageUrl;

    @Column(name = "HeaderImageAttribution", columnDefinition = "TEXT")
    private String headerImageAttribution;

    @Column(name = "SourceDomain", length = 63, nullable = false)
    private String sourceDomain;

    @Column(name = "SortedCategoriesJson", columnDefinition = "TEXT", nullable = false)
    private String sortedCategoriesJson;

    @Column(name = "OriginalUrl", columnDefinition = "TEXT", nullable = false)
    private String originalUrl;

    @Column(name = "Content", columnDefinition = "TEXT", nullable = false)
    private String content;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDateWritten() {
        return this.dateWritten;
    }

    public void setDateWritten(String dateWritten) {
        this.dateWritten = dateWritten;
    }

    public String getByLine() {
        return this.byLine;
    }

    public void setByLine(String byLine) {
        this.byLine = byLine;
    }

    public String getHeaderImageUrl() {
        return this.headerImageUrl;
    }

    public void setHeaderImageUrl(String headerImageUrl) {
        this.headerImageUrl = headerImageUrl;
    }

    public String getHeaderImageAttribution() {
        return this.headerImageAttribution;
    }

    public void setHeaderImageAttribution(String headerImageAttribution) {
        this.headerImageAttribution = headerImageAttribution;
    }

    public String getSourceDomain() {
        return this.sourceDomain;
    }

    public void setSourceDomain(String sourceDomain) {
        this.sourceDomain = sourceDomain;
    }

    public String getSortedCategoriesJson() {
        return this.sortedCategoriesJson;
    }

    public void setSortedCategoriesJson(String sortedCategoriesJson) {
        this.sortedCategoriesJson = sortedCategoriesJson;
    }

    public String getOriginalUrl() {
        return this.originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
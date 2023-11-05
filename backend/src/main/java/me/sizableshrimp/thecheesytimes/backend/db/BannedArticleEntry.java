package me.sizableshrimp.thecheesytimes.backend.db;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // This tells Hibernate to make a table out of this class
@Table(name = "BannedArticles")
public class BannedArticleEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "BannedId")
    private Integer bannedArticleId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBannedArticleId() {
        return bannedArticleId;
    }

    public void setBannedArticleId(Integer bannedArticleId) {
        this.bannedArticleId = bannedArticleId;
    }
}

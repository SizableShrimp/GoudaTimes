package me.sizableshrimp.thecheesytimes.backend.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;
    private final BannedArticleRepository bannedArticleRepository;

    public ArticleService(ArticleRepository articleRepository, BannedArticleRepository bannedArticleRepository) {
        this.articleRepository = articleRepository;
        this.bannedArticleRepository = bannedArticleRepository;
    }

    public Optional<Article> findById(Integer id) {
        return this.articleRepository.findById(id)
                .filter(article -> !this.getBannedArticleIds().contains(article.getId()))
                .map(Article::sanitize);
    }

    public List<Article> findAll() {
        return this.articleRepository.findAll(this.filterEnabledArticles()).stream().map(Article::sanitize).toList();
    }

    public Iterable<Article> findAll(Sort sort) {
        return () -> this.articleRepository.findAll(this.filterEnabledArticles(), sort).stream()
                .map(Article::sanitize)
                .iterator();
    }

    public Page<Article> findAll(Pageable pageable) {
        return this.articleRepository.findAll(this.filterEnabledArticles(), pageable).map(Article::sanitize);
    }

    private Specification<Article> filterEnabledArticles() {
        return (root, query, builder) -> builder.not(root.get("id").in(query.from(BannedArticleEntry.class).get("bannedArticleId")));
    }

    private List<Integer> getBannedArticleIds() {
        return this.bannedArticleRepository.findAll().stream().map(BannedArticleEntry::getBannedArticleId).toList();
    }
}

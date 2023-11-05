package me.sizableshrimp.thecheesytimes.backend.db;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Optional<Article> findById(Integer id) {
        return this.articleRepository.findById(id).map(Article::sanitize);
    }

    public List<Article> findAll() {
        return this.articleRepository.findAll().stream().map(Article::sanitize).toList();
    }

    public Iterable<Article> findAll(Sort sort) {
        return () -> StreamSupport.stream(this.articleRepository.findAll(sort).spliterator(), false)
                .map(Article::sanitize)
                .iterator();
    }

    public Page<Article> findAll(Pageable pageable) {
        return this.articleRepository.findAll(pageable).map(Article::sanitize);
    }
}

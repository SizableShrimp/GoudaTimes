package me.sizableshrimp.thecheesytimes.backend.db;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface ArticleRepository extends ReadOnlyRepository<Article, Integer>, PagingAndSortingRepository<Article, Integer> {}

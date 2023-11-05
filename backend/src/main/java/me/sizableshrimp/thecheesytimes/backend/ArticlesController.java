package me.sizableshrimp.thecheesytimes.backend;

import me.sizableshrimp.thecheesytimes.backend.db.Article;
import me.sizableshrimp.thecheesytimes.backend.db.ArticleRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/articles")
public class ArticlesController {
    private final ArticleRepository articleRepository;

    // The parameters here are automatically injected for us
    public ArticlesController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Article> index() {
        return articleRepository.findAll();
    }
}
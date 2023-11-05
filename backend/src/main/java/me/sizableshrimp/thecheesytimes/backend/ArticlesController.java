package me.sizableshrimp.thecheesytimes.backend;

import jakarta.persistence.EntityNotFoundException;
import me.sizableshrimp.thecheesytimes.backend.db.Article;
import me.sizableshrimp.thecheesytimes.backend.db.ArticleRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/articles")
public class ArticlesController {
    private final ArticleRepository articleRepository;

    // The parameters here are automatically injected for us
    public ArticlesController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @CrossOrigin
    @GetMapping("")
    public @ResponseBody Iterable<Article> index() {
        return this.articleRepository.findAll();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public Article findById(@PathVariable Integer id) {
        return this.articleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Could not find article with id " + id));
    }
}
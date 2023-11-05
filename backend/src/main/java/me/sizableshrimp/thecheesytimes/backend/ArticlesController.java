package me.sizableshrimp.thecheesytimes.backend;

import me.sizableshrimp.thecheesytimes.backend.db.Article;
import me.sizableshrimp.thecheesytimes.backend.db.ArticleRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/articles")
@CrossOrigin
public class ArticlesController {
    private final ArticleRepository articleRepository;

    // The parameters here are automatically injected for us
    public ArticlesController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping("")
    public @ResponseBody Iterable<Article> index() {
        return this.articleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable Integer id) {
        return this.getOrReturn404Response(this.articleRepository.findById(id));
    }

    private <T> Object getOrReturn404Response(Optional<T> result) {
        return result.isPresent() ? result.get() : ApiErrorResponse.resourceNotFound();
    }
}
package me.sizableshrimp.thecheesytimes.backend;

import me.sizableshrimp.thecheesytimes.backend.db.Article;
import me.sizableshrimp.thecheesytimes.backend.db.ArticleRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

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
    public @ResponseBody Iterable<Article> index(@RequestParam(value = "filterDomain", required = false) String filterDomain, Pageable pageable) {
        if (filterDomain == null) {
            return () -> this.articleRepository.findAll(pageable).stream()
                    .map(Article::shrink).iterator();
        }

        return () -> this.articleRepository.findAll(pageable).stream()
                .filter(article -> article.getSourceDomain().equals(filterDomain))
                .map(Article::shrink).iterator();
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable Integer id) {
        return this.getOrReturn404Response(this.articleRepository.findById(id));
    }

    private <T> Object getOrReturn404Response(Optional<T> result) {
        return result.isPresent() ? result.get() : ApiErrorResponse.resourceNotFound();
    }
}
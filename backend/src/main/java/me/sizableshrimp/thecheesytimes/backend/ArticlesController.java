package me.sizableshrimp.thecheesytimes.backend;

import me.sizableshrimp.thecheesytimes.backend.db.Article;
import me.sizableshrimp.thecheesytimes.backend.db.ArticleService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/articles")
@CrossOrigin
public class ArticlesController {
    private final ArticleService articleService;

    // The parameters here are automatically injected for us
    public ArticlesController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping("")
    public @ResponseBody Iterable<Article> index(@RequestParam(value = "filterDomain", required = false) String filterDomain, Pageable pageable) {
        if (filterDomain == null) {
            return () -> this.articleService.findAll(pageable).stream()
                    .map(Article::shrink).iterator();
        }

        return () -> this.articleService.findAll(pageable).stream()
                .filter(article -> article.getSourceDomain().equals(filterDomain))
                .map(Article::shrink).iterator();
    }

    @GetMapping("/{id}")
    public Object findById(@PathVariable Integer id) {
        return this.getOrReturn404Response(this.articleService.findById(id));
    }

    private <T> Object getOrReturn404Response(Optional<T> result) {
        return result.isPresent() ? result.get() : ApiErrorResponse.resourceNotFound();
    }
}
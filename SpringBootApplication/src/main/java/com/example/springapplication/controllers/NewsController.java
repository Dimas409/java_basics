package com.example.springapplication.controllers;

import com.example.springapplication.dto.NewsDTO;
import com.example.springapplication.service.NewsFeedService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/news")
public class NewsController {
    private final NewsFeedService newsService;

    public NewsController(NewsFeedService newsService) {
        this.newsService = newsService;
    }
    @GetMapping("/{id}")
    public NewsDTO getNewsById(@PathVariable Long id) {
        return newsService.getById(id);
    }
    @GetMapping
    public Collection<NewsDTO> getAllNews() {
        return newsService.getAll();
    }
    @PostMapping
    public void createNews(@RequestBody NewsDTO newsDTO) {
        newsService.create(newsDTO);
    }
    @PutMapping("/{id}")
    public void updateNews(@PathVariable Long id, @RequestBody NewsDTO newsDTO) {
        newsService.update(id, newsDTO);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteById(id);
    }
}

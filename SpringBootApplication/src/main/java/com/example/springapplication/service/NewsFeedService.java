package com.example.springapplication.service;

import com.example.springapplication.dto.NewsDTO;
import com.example.springapplication.exception.NewsNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class NewsFeedService implements CRUDService<NewsDTO> {
    private final ConcurrentHashMap<Long, NewsDTO> storage = new ConcurrentHashMap<>();
    @Override
    public NewsDTO getById(Long id) {
        NewsDTO news = storage.get(id);
            if (news == null) {
                throw new NewsNotFoundException(id);
            }
        return news;
    }

    @Override
    public Collection<NewsDTO> getAll() {
        return storage.values();
    }

    @Override
    public void create(NewsDTO item) {
        long nextId = (storage.isEmpty() ? 0 : storage.size()) + 1;
        item.setId(nextId);
        item.setDate(Instant.now());
        storage.put(nextId, item);
    }

    @Override
    public void update(Long id, NewsDTO item) {
        if (!storage.containsKey(id)) {
            throw new NewsNotFoundException(id);
        }
        item.setId(id);
        item.setDate(Instant.now());
        storage.put(id, item);
    }

    @Override
    public void deleteById(Long id) {
        NewsDTO news = storage.get(id);
        if (news == null) {
            throw new NewsNotFoundException(id);
        }
        storage.remove(id);
    }
}

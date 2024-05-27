package com.example.springapplication.service;

import com.example.springapplication.Entity.Category;
import com.example.springapplication.dto.CategoryDto;
import com.example.springapplication.exception.CategoryNotFoundException;
import com.example.springapplication.repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Slf4j
@Service
@RequiredArgsConstructor
public class CategoryService implements CRUDService<CategoryDto> {
    private final CategoryRepository categoryRepository;
    @Override
    public CategoryDto getById(Long id) {
        log.info("Get by Id: " + id);
        return mapToDto(categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id)));
    }

    @Override
    public Collection<CategoryDto> getAll() {
        log.info("Get All");
        return categoryRepository.findAll().stream()
                .map(CategoryService::mapToDto)
                .toList();
    }

    @Override
    public CategoryDto create(CategoryDto categoryDto) {
        log.info("Create");
        Category category = mapToEntity(categoryDto);
        return mapToDto(categoryRepository.save(category));
    }

    @Override
    public CategoryDto update(CategoryDto categoryDto) {
        log.info("Update " + categoryDto.getId());
        Category existingCategory = categoryRepository
                .findById(categoryDto.getId())
                .orElseThrow(() -> new CategoryNotFoundException(categoryDto.getId()));
        existingCategory.setTitle(categoryDto.getTitle());
        return mapToDto(categoryRepository.save(existingCategory));
    }

    @Override
    public void delete(Long id) {
        log.info("Delete " + id);
        Category category = categoryRepository
                .findById(id)
                .orElseThrow(() -> new CategoryNotFoundException(id));
        categoryRepository.deleteById(category.getId());
    }
    public static CategoryDto mapToDto(Category category) {
        return CategoryDto.builder()
                .id(category.getId())
                .title(category.getTitle())
                .build();
    }
    private Category mapToEntity(CategoryDto categoryDto) {
        return Category.builder()
                .id(categoryDto.getId())
                .title(categoryDto.getTitle())
                .build();
    }

}

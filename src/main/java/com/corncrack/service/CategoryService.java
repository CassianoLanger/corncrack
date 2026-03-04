package com.corncrack.service;

import com.corncrack.entity.Category;
import com.corncrack.mapper.CategoryMapper;
import com.corncrack.repository.CategoryRepository;
import com.corncrack.request.CategoryRequest;
import com.corncrack.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    public List<CategoryResponse> getAll() {
        List<Category> categories = new LinkedList<>(repository.findAll());

        return categories.stream().map(CategoryMapper::toResponse).toList();
    }

    public CategoryResponse save(CategoryRequest request) {
        Category category = CategoryMapper.toCategory(request);
        category = repository.save(category);
        return CategoryMapper.toResponse(category);
    }

    public Optional<Category> getCategoryById(Long id) {
       return repository.findById(id);
    }

    public void deleteCategoryById(Long id) {
        repository.deleteById(id);
    }
}

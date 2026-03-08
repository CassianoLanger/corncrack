package com.corncrack.service;

import com.corncrack.entity.Category;
import com.corncrack.mapper.CategoryMapper;
import com.corncrack.repository.CategoryRepository;
import com.corncrack.request.CategoryRequest;
import com.corncrack.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
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
        return CategoryMapper.toResponse(repository.save(CategoryMapper.toCategory(request)));
    }

    public Optional<CategoryResponse> getCategoryById(Long id) {
       return repository.findById(id).map(CategoryMapper::toResponse);
    }

    public Boolean deleteCategoryById(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public List<CategoryResponse> saveAll(List<CategoryRequest> requests) {
        List<Category> responses = repository.saveAll(requests.stream().map(CategoryMapper::toCategory).toList());
        return responses.stream().map(CategoryMapper::toResponse).toList();

    }
}

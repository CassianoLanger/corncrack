package com.corncrack.controller;

import com.corncrack.mapper.CategoryMapper;
import com.corncrack.request.CategoryRequest;
import com.corncrack.response.CategoryResponse;
import com.corncrack.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/corncrack/category")
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getAll());
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody @Valid CategoryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @GetMapping("{id}")
    public ResponseEntity<CategoryResponse> getCategory(@PathVariable Long id){
        return service.getCategoryById(id).map(categoty -> ResponseEntity.ok(CategoryMapper.toResponse(categoty)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
         service.deleteCategoryById(id);
         return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

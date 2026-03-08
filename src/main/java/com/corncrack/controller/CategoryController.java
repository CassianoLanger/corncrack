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

import java.io.Serializable;
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

    @PostMapping("/new-category")
    public ResponseEntity<CategoryResponse> saveCategory(@RequestBody @Valid CategoryRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getById(@PathVariable Long id){
        return service.getCategoryById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long id){
        String status = service.deleteCategoryById(id) ? "Deletado" : "Verifique o id informado";
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }
    @PostMapping("/batch")
    public ResponseEntity<List<CategoryResponse>> saveCategories(@RequestBody List<CategoryRequest> requests){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAll(requests));
    }
}

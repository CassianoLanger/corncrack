package com.corncrack.controller;

import com.corncrack.request.MovieRequest;
import com.corncrack.response.MovieResponse;
import com.corncrack.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/corncrack/movie")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService service;

    @GetMapping
    public ResponseEntity<List<MovieResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.findAll());
    }

    @PostMapping
    public ResponseEntity<MovieResponse> save(@RequestBody MovieRequest request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @GetMapping("/{title}")
    public ResponseEntity<MovieResponse> findMovie(@PathVariable String title){
        return ResponseEntity.ok(service.findMovie(title));
    }

    @PostMapping("/batch")
    public ResponseEntity<List<MovieResponse>> saveAll(@RequestBody List<MovieRequest>request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAll(request));
    }

}

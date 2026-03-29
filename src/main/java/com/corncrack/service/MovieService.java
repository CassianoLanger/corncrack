package com.corncrack.service;

import com.corncrack.entity.Category;
import com.corncrack.entity.Movie;
import com.corncrack.mapper.MovieMapper;
import com.corncrack.repository.MovieRepository;
import com.corncrack.request.MovieRequest;
import com.corncrack.response.MovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;
    private final CategoryService categoryService;

    public List<MovieResponse> findAll(){
        return repository.findAll().stream()
                .map(MovieMapper::toResponse)
                .toList();
    }

    public MovieResponse save(MovieRequest request) {
        Movie movie = MovieMapper.toMovie(request);
        return MovieMapper.toResponse(repository.save(movie));
    }

    public MovieResponse findMovie(String request){
        return MovieMapper.toResponse(repository.findMovieByTitle(request));
    }

    public List<MovieResponse> saveAll(List<MovieRequest> request){
        List<Movie> movies = repository.saveAll(request.stream().map(MovieMapper::toMovie).toList());
        return movies.stream().map(MovieMapper::toResponse).toList();
    }

    private List<Category> findCategories(List<Category> categories){
        List<Category> categoriesFound = new ArrayList<>();

        categories.forEach(e -> {
            if(categoryService.getCategoryById(e.getId()).isPresent()){
                categoriesFound.add(e);
            }
        });

        return categoriesFound;
    }


}

package com.corncrack.service;

import com.corncrack.entity.Movie;
import com.corncrack.mapper.MovieMapper;
import com.corncrack.repository.MovieRepository;
import com.corncrack.request.MovieRequest;
import com.corncrack.response.MovieResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repository;

    public List<MovieResponse> findAll(){
        return repository.findAll().stream()
                .map(MovieMapper::toResponse)
                .toList();
    }

    public MovieResponse save(MovieRequest request) {
        Movie movie = MovieMapper.toMovie(request);
        return MovieMapper.toResponse(repository.save(movie));
    }


}

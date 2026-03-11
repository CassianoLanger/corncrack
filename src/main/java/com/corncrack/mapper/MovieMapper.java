package com.corncrack.mapper;

import com.corncrack.entity.Category;
import com.corncrack.entity.Movie;
import com.corncrack.entity.Streaming;
import com.corncrack.request.MovieRequest;
import com.corncrack.response.CategoryResponse;
import com.corncrack.response.MovieResponse;
import com.corncrack.response.StreamingResponse;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class MovieMapper {

    public static Movie toMovie(MovieRequest request){

        List<Category> categories = request.categories().stream()
                .map(categoryId -> Category.builder().id(categoryId).build())
                .toList();

        List<Streaming> streamings = request.streamings().stream()
                .map(streamingId -> Streaming.builder().id(streamingId).build())
                .toList();

        return Movie.builder()
                .title(request.title())
                .description(request.description())
                .releaseDate(request.releaseDate())
                .rate(request.rate())
                .categories(categories)
                .streamings(streamings)
                .build();
    }

    public static MovieResponse toResponse(Movie movie){
        List<CategoryResponse> categories = movie.getCategories().stream()
                .map(CategoryMapper::toResponse)
                .toList();

        List<StreamingResponse> streaming = movie.getStreamings().stream().map(StreamingMapper::toResponse)
                .toList();

        return MovieResponse.builder()
                .title(movie.getTitle())
                .description(movie.getDescription())
                .releaseDate(movie.getReleaseDate())
                .rate(movie.getRate())
                .categories(categories)
                .streamings(streaming)
                .build();
    }
}

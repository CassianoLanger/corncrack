package com.corncrack.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieResponse(Long id,
                            String title,
                            String description,
                            LocalDate releaseDate,
                            double rate,
                            List<CategoryResponse> categories,
                            List<StreamingResponse> streamings
                            ){
}

package com.corncrack.request;

import lombok.Builder;

import java.time.LocalDate;
import java.util.List;

@Builder
public record MovieRequest (String title,
                            String description,
                            LocalDate releaseDate,
                            double rate,
                            List<Long> categories,
                            List<Long> streamings
                            ){
}

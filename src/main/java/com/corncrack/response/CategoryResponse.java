package com.corncrack.response;

import lombok.Builder;

@Builder
public record CategoryResponse(Long id, String name) {
}

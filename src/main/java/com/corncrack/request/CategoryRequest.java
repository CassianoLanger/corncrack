package com.corncrack.request;

import lombok.Builder;


@Builder
public record CategoryRequest(String name) {
}

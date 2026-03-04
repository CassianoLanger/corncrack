package com.corncrack.mapper;

import com.corncrack.entity.Streaming;
import com.corncrack.request.StremingRequest;
import com.corncrack.response.StreamingResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreming(StremingRequest stremingRequest){
        return Streaming.builder()
                .name(stremingRequest.name())
                .build();
    }

    public static StreamingResponse toResponse(Streaming streaming){
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}

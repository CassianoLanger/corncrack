package com.corncrack.service;

import com.corncrack.entity.Streaming;
import com.corncrack.mapper.StreamingMapper;
import com.corncrack.repository.StreamingRepository;
import com.corncrack.response.StreamingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    public List<StreamingResponse> getAll() {
        List<Streaming> streamings = new LinkedList<>(repository.findAll());
        return streamings.stream().map(StreamingMapper::toResponse).toList();
    }
}

package com.corncrack.service;

import com.corncrack.entity.Streaming;
import com.corncrack.mapper.StreamingMapper;
import com.corncrack.repository.StreamingRepository;
import com.corncrack.request.StremingRequest;
import com.corncrack.response.StreamingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StreamingService {

    private final StreamingRepository repository;

    public List<StreamingResponse> getAll() {

        return repository.findAll().stream().map(StreamingMapper::toResponse).toList();
    }

    public StreamingResponse save(StremingRequest stremingRequest) {
        Streaming entity = StreamingMapper.toStreming(stremingRequest);
        return StreamingMapper.toResponse(repository.save(entity));
    }
}

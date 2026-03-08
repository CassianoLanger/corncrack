package com.corncrack.service;

import com.corncrack.entity.Streaming;
import com.corncrack.mapper.StreamingMapper;
import com.corncrack.repository.StreamingRepository;
import com.corncrack.request.StremingRequest;
import com.corncrack.response.StreamingResponse;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<StreamingResponse> getById(Long id) {
        return repository.findById(id).map(StreamingMapper::toResponse);
    }

    public Boolean delete(Long id) {
        if (repository.existsById(id)){
            repository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public  List<StreamingResponse> saveAll(List<StremingRequest> request) {
        
         List<Streaming> streamings = repository.saveAll(request.stream()
                .map(StreamingMapper::toStreming)
                .toList());
         
         return streamings.stream().map(StreamingMapper::toResponse).toList();
    }
}

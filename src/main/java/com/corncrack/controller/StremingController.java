package com.corncrack.controller;

import com.corncrack.mapper.StreamingMapper;
import com.corncrack.request.StremingRequest;
import com.corncrack.response.StreamingResponse;
import com.corncrack.service.StreamingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/corncrack/streaming")
public class StremingController {

    private final StreamingService service;

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> getAll(){
        return ResponseEntity.status(HttpStatus.FOUND).body(service.getAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<StreamingResponse> getById(@PathVariable Long id){
        return service.getById(id).map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<StreamingResponse> save(@RequestBody StremingRequest stremingRequest){
        StreamingResponse streamingResponse = service.save(stremingRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(streamingResponse);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        String status = service.delete(id) ? "Deletado" : "Verifique o id informado";
        return ResponseEntity.status(HttpStatus.OK).body(status);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<StreamingResponse>> saveAll(@RequestBody List<StremingRequest> request){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.saveAll(request));
    }
}

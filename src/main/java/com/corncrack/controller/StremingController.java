package com.corncrack.controller;

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

    @PostMapping
    public ResponseEntity<StreamingResponse> save(@RequestBody StremingRequest stremingRequest){
        StreamingResponse streamingResponse = service.save(stremingRequest);
        return null;
    }
}

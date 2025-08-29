package com.example.bfhlapi.controller;

import com.example.bfhlapi.dto.DataRequest;
import com.example.bfhlapi.dto.DataResponse;
import com.example.bfhlapi.service.DataProcessingService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class BfhlController {
    
    @Autowired
    private DataProcessingService dataProcessingService;
    
    @PostMapping("/bfhl")
    public ResponseEntity<DataResponse> processData(@Valid @RequestBody DataRequest request) {
        try {
            DataResponse response = dataProcessingService.processData(request.getData());
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Return error response with 500 status
            DataResponse errorResponse = new DataResponse(
                false,
                "error_user_id",
                "error@example.com",
                "ERROR123",
                new java.util.ArrayList<>(),
                new java.util.ArrayList<>(),
                new java.util.ArrayList<>(),
                new java.util.ArrayList<>(),
                "0",
                ""
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
        }
    }
    

}

package com.example.bfhlapi.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public class DataRequest {
    
    @NotNull(message = "Data array cannot be null")
    @NotEmpty(message = "Data array cannot be empty")
    private List<String> data;
    
    public DataRequest() {}
    
    public DataRequest(List<String> data) {
        this.data = data;
    }
    
    public List<String> getData() {
        return data;
    }
    
    public void setData(List<String> data) {
        this.data = data;
    }
}

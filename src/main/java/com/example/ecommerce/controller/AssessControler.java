package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.AssessRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.entity.Assess;
import com.example.ecommerce.service.AssessService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Data
@RequestMapping("/assess")
public class AssessControler {
    AssessService assessService;
    public AssessControler(AssessService assessService){
        this.assessService = assessService;
    }

    @PostMapping
    public ApiResponse<Assess> createAssess(@RequestBody AssessRequest request){

        return ApiResponse.<Assess>builder()
                .data(assessService.createAssess(request))
                .code(200)
                .message("create successfully")
                .build();
    }
    @GetMapping("/{productId}")
    public ApiResponse<List<Assess>> getAssess(@PathVariable String productId){
        return ApiResponse.<List<Assess>>builder()
                .message("get successfully")
                .data(assessService.getAssess(productId))
                .code(200)
                .build();
    }

}

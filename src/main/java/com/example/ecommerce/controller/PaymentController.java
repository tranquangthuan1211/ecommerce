package com.example.ecommerce.controller;

import com.example.ecommerce.dto.request.PaymentRequest;
import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.entity.Payment;
import com.example.ecommerce.service.PaymentService;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Data
@RestController
@RequestMapping("/payment")
public class PaymentController {
    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    public ApiResponse<Payment> createPayment(PaymentRequest request){

        return ApiResponse.<Payment>builder()
                .code(200)
                .message("create successfully")
                .data(paymentService.createPayment(request))
                .build();
    }
}

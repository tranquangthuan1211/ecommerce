package com.example.ecommerce.controller;

import com.example.ecommerce.dto.response.ApiResponse;
import com.example.ecommerce.service.EmailService;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/send-mail")
public class EmailController {
    private EmailService emailService;

    public EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @GetMapping
    public ApiResponse<String> sendMail() {
        try {
            emailService.sendEmail("tranthuan.121104@gmail.com", "hello", "cho minh lam quen");
            return ApiResponse.<String>builder()
                    .code(200)
                    .message("send mail successfully")
                    .build();
        } catch (MessagingException e) {
            return ApiResponse.<String>builder()
                    .code(401)
                    .message("error send mail")
                    .build();
        }
    }

}

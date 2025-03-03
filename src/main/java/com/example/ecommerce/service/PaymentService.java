package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.PaymentRequest;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.Payment;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.PaymentRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class PaymentService {
    private PaymentRepository paymentRepository;
    private UserRepository userRepository;
    private CartRepository cartRepository;

    PaymentService(PaymentRepository paymentRepository, UserRepository userRepository, CartRepository cartRepository){
        this.paymentRepository = paymentRepository;
        this.userRepository = userRepository;
        this.cartRepository = cartRepository;
    }

    public Payment createPayment(PaymentRequest request){
        Optional<User> userOptional = userRepository.findById(request.getUserId());
        Optional<Cart> cartOptional = cartRepository.findById(request.getCartId());

        if(userOptional.isEmpty() &&  cartOptional.isEmpty()) throw  new RuntimeException();
        Payment payment = Payment.builder()
                .cart(cartOptional.get())
                .user(userOptional.get())
                .build();
        return paymentRepository.save(payment);
    }
}

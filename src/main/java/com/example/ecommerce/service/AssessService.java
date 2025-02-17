package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.AssessRequest;
import com.example.ecommerce.entity.Assess;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.AssessRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class AssessService {
    AssessRepository assessRepository;
    UserRepository userRepository;
    ProductRepository productRepository;

    public AssessService(AssessRepository assessRepository,
                         UserRepository userRepository,
                         ProductRepository productRepository){
        this.assessRepository = assessRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Assess createAssess(AssessRequest request) {
        Optional<User> user = userRepository.findById(request.getUser_id());
        Optional<Product> product = productRepository.findById(request.getProduct_id());
        if(user.isPresent() && product.isPresent()){
            Assess assess = new Assess();
            assess.setComment(request.getComment());
            assess.setUser(user.get());
            assess.setProduct(product.get());

            return assessRepository.save(assess);
        }else {
            throw new RuntimeException("error");
        }
    }
    public List<Assess> getAssess(String productId){
        return assessRepository.findByProductId(productId);
    }
}

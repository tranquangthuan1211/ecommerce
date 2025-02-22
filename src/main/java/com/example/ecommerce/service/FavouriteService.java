package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.FavouriteRequest;
import com.example.ecommerce.entity.Favourite;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.FavouriteRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Data
public class FavouriteService {
    private FavouriteRepository favouriteRepository;
    private UserRepository userRepository;
    private ProductRepository productRepository;

    public FavouriteService(
            FavouriteRepository favouriteRepository,
            UserRepository userRepository,
            ProductRepository productRepository
    ){
        this.favouriteRepository = favouriteRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    public Favourite createFavourite(FavouriteRequest request){
        Optional<User> user = userRepository.findById(request.getUser_id());
        Optional<Product> product = productRepository.findById(request.getProduct_id());
        if(user.isEmpty() || product.isEmpty()) throw new RuntimeException("error");
        Favourite newFavourite = new Favourite();
        newFavourite.setUser(user.get());
        newFavourite.setProduct(product.get());
        return favouriteRepository.save(newFavourite);
    }

}

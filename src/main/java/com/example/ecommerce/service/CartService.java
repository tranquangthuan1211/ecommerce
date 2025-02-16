package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.CartRequest;
import com.example.ecommerce.dto.response.CartResponse;
import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.exception.AppException;
import com.example.ecommerce.exception.ErrorCode;
import com.example.ecommerce.repository.CartItemRepository;
import com.example.ecommerce.repository.CartRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
@Data
public class CartService {
    CartRepository cartRepository;
    CartItemRepository cartItemRepository;
    UserRepository userRepository;
    ProductRepository productRepository;


    public CartService(
            CartRepository cartRepository,
            CartItemRepository cartItemRepository,
            ProductRepository productRepository,
            UserRepository userRepository
    ){
        this.cartRepository = cartRepository;
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }
    public Cart createCart(CartRequest request) {
        Optional<User> user = userRepository.findById(request.getUser_id());
        if(user.isEmpty()) throw new AppException(ErrorCode.USER_NOT_EXISTS);
        Cart cart = new Cart();
        cart.setUser(user.get());
        return cartRepository.save(cart);
    }
    public CartResponse getCart(String cartId){
        Optional<Cart> cart = cartRepository.findById(cartId);
        if(cart.isEmpty()) throw new RuntimeException("cart not found");

        return new CartResponse(cart.get());
    }
    public CartResponse addToCart(String cartId, CartRequest request) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);
        Optional<Product> product = productRepository.findById(request.getProduct_id());
        if (optionalCart.isPresent()) {
            CartItem item = new CartItem();
            Cart cart = optionalCart.get();
            item.setCart(cart);
            item.setProduct(product.get());
            item.setQuantity(request.getQuantity());
            cartItemRepository.save(item);
            return new CartResponse(optionalCart.get());
        } else {
            throw new RuntimeException("Cart or Product not found");
        }
    }
    public void clearCartItem(String cartId){
        Optional<Cart> cartOptional = cartRepository.findById(cartId);

        if(cartOptional.isPresent()){
            Cart cart = cartOptional.get();
            cartRepository.deleteById(cartId);
        }else {
            throw new RuntimeException("Cart not found");
        }
    }
}

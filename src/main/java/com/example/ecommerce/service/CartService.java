package com.example.ecommerce.service;

import com.example.ecommerce.dto.request.CartRequest;
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
    public Cart creteCart(CartRequest request) {
        Optional<User> user = userRepository.findById(request.getUser_id());
        if(!user.isPresent()) throw new AppException(ErrorCode.USER_NOT_EXISTS);
        Cart cart = new Cart();
        cart.setUser(user.get());
        return cartRepository.save(cart);
    }
    public Cart addToCart(CartRequest request){
        Optional<Product> productOptional = productRepository.findById(request.getProduct_id());
        Optional<User> user = userRepository.findById(request.getUser_id());
        if (productOptional.isPresent()) {
            Cart newCart = new Cart();
            Product product = productOptional.get();
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setQuantity(request.getQuantity());
            cartItemRepository.save(cartItem);
            HashSet<CartItem> items = new HashSet<>();
            items.add(cartItem);
            newCart.setItems(items);
            newCart.setUser(user.get());
            return cartRepository.save(newCart);
        } else {
            throw new RuntimeException("Cart or Product not found");
        }
    }
    public void clearCartItem(String cartId){
        Optional<Cart> cartOptional = cartRepository.findById(cartId);

        if(cartOptional.isPresent()){
            Cart cart = cartOptional.get();
            cart.getItems().clear();
            cartRepository.deleteById(cartId);
        }else {
            throw new RuntimeException("Cart not found");
        }
    }
}

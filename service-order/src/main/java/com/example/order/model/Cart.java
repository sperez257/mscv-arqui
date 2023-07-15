package com.example.order.model;

import jakarta.persistence.*;
import lombok.Data;



public class Cart {


    private Integer cartId;


    private String userName;


    private Integer productId;


    private Product product;

    private User user;



    public Cart(Integer product, String user) {
        this.productId = product;
        this.userName = user;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

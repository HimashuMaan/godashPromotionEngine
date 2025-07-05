package com.goDash.promotionEngine.promotionEngine.service;

import com.goDash.promotionEngine.promotionEngine.model.CartItem;

import java.util.List;

public interface CheckoutService {
    public int calculateTotal(List<CartItem> cartItems);
}

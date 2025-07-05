package com.goDash.promotionEngine.promotionEngine.promotionSystem;

import com.goDash.promotionEngine.promotionEngine.dto.CartRequest;
import com.goDash.promotionEngine.promotionEngine.model.CartItem;

import java.util.List;

public interface Promotion {
    boolean isApplicable(List<CartItem> cartItems);
    int apply (List<CartItem> cartItems);
}

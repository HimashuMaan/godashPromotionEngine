package com.goDash.promotionEngine.promotionEngine.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class CartItem {
    private SKU sku;
    private int quantity;
}

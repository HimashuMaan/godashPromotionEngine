package com.goDash.promotionEngine.promotionEngine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemDto {
    private String skuId;
    private int quantity;
}

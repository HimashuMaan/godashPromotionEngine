package com.goDash.promotionEngine.promotionEngine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class CartRequest {
    private List<CartItemDto> items;
}

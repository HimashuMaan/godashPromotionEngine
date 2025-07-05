package com.goDash.promotionEngine.promotionEngine.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@AllArgsConstructor
public class CartRequest {
    private List<CartItemDto> items;

    public List<CartItemDto> getItems() {
        return items;
    }
}

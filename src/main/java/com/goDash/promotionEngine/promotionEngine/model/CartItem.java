package com.goDash.promotionEngine.promotionEngine.model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
public class CartItem {
    private SKU sku;
    private int quantity;

    public CartItem(SKU sku, int quantity) {
        this.sku = sku;
        this.quantity = quantity;
    }

    public SKU getSku() {
        return sku;
    }

    public void setSku(SKU sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

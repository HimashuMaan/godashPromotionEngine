package com.goDash.promotionEngine.promotionEngine.promotionTest;

import com.goDash.promotionEngine.promotionEngine.model.CartItem;
import com.goDash.promotionEngine.promotionEngine.model.SKU;
import com.goDash.promotionEngine.promotionEngine.promotionSystem.PromotionComboFor30;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PromotionComboFor30Test {

    private final PromotionComboFor30 promo = new PromotionComboFor30();

    @Test
    void exactly1Cand1D() {
        int total = promo.apply(List.of(
                new CartItem(new SKU("C", 20), 1),
                new CartItem(new SKU("D", 15), 1)
        ));
        assertEquals(30, total);
    }

    @Test
    void exactly2Cand2D() {
        int total = promo.apply(List.of(
                new CartItem(new SKU("C", 20), 2),
                new CartItem(new SKU("D", 15), 2)
        ));
        assertEquals(60, total);
    }

    @Test
    void exactly1C() {
        CartItem itemC = new CartItem(new SKU("C", 20), 1);
        List<CartItem> cart = List.of(itemC);

        int total = 0;
        if (promo.isApplicable(cart)) {
            total += promo.apply(cart);
        } else {
            // No promotion applied, pay full price
            total += itemC.getSku().getPrice() * itemC.getQuantity();
        }

        assertEquals(20, total);
    }

    @Test
    void exactly1D() {
        CartItem itemD = new CartItem(new SKU("D", 15), 1);
        List<CartItem> cart = List.of(itemD);

        int total = 0;
        if (promo.isApplicable(cart)) {
            total += promo.apply(cart);
        } else {
            total += itemD.getSku().getPrice() * itemD.getQuantity();
        }

        assertEquals(15, total);
    }

}


package com.goDash.promotionEngine.promotionEngine.promotionTest;

import com.goDash.promotionEngine.promotionEngine.model.CartItem;
import com.goDash.promotionEngine.promotionEngine.model.SKU;
import com.goDash.promotionEngine.promotionEngine.promotionSystem.PromotionTwoFor45;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoAFor45PromotionTest {

    private final PromotionTwoFor45 promo = new PromotionTwoFor45();

    @Test
    void exactlyTwoB() {
        int total = promo.apply(List.of(
                new CartItem(new SKU("B", 30), 2)
        ));
        assertEquals(45, total);
    }

    @Test
    void fourB() {
        int total = promo.apply(List.of(
                new CartItem(new SKU("B", 30), 4)
        ));
        assertEquals(90, total);
    }
    @Test
    void oneB() {
        int total = promo.apply(List.of(
                new CartItem(new SKU("B", 30), 1)
        ));
        assertEquals(30, total);
    }
}


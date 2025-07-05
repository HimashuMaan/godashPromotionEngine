package com.goDash.promotionEngine.promotionEngine.promotionTest;

import com.goDash.promotionEngine.promotionEngine.model.CartItem;
import com.goDash.promotionEngine.promotionEngine.model.SKU;
import com.goDash.promotionEngine.promotionEngine.promotionSystem.PromotionThreeFor130;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeAFor130PromotionTest {

    private final PromotionThreeFor130 promo = new PromotionThreeFor130();

    @Test
    void exactlyThreeA() {
        int total = promo.apply(List.of(
                new CartItem(new SKU("A", 50), 3)
        ));
        assertEquals(130, total);
    }

    @Test
    void fourA() {
        int total = promo.apply(List.of(
                new CartItem(new SKU("A", 50), 4)
        ));
        assertEquals(180, total);
    }
    @Test
    void twoA() {
        int total = promo.apply(List.of(
                new CartItem(new SKU("A", 50), 2)
        ));
        assertEquals(100, total);
    }
    @Test
    void oneA() {
        int total = promo.apply(List.of(
                new CartItem(new SKU("A", 50), 1)
        ));
        assertEquals(50, total);
    }
}


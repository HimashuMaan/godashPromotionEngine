package com.goDash.promotionEngine.promotionEngine.promotionTest;

import com.goDash.promotionEngine.promotionEngine.model.CartItem;
import com.goDash.promotionEngine.promotionEngine.model.SKU;
import com.goDash.promotionEngine.promotionEngine.promotionSystem.Promotion;
import com.goDash.promotionEngine.promotionEngine.promotionSystem.PromotionComboFor30;
import com.goDash.promotionEngine.promotionEngine.promotionSystem.PromotionThreeFor130;
import com.goDash.promotionEngine.promotionEngine.promotionSystem.PromotionTwoFor45;
import com.goDash.promotionEngine.promotionEngine.service.CheckoutService;
import com.goDash.promotionEngine.promotionEngine.service.CheckoutServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class misliniousPromotionTest {
    private CheckoutService checkoutService;

    @BeforeEach
    void setUp() {
        List<Promotion> promotions = List.of(
                new PromotionThreeFor130(),
                new PromotionTwoFor45(),
                new PromotionComboFor30()
        );
        checkoutService = new CheckoutServiceImpl(promotions);
    }

    @Test
    void comboPromotionAppliesCorrectly() {
        List<CartItem> cart = List.of(
                new CartItem(new SKU("A", 50), 3),
                new CartItem(new SKU("B", 30), 5),
                new CartItem(new SKU("C", 20), 1),
                new CartItem(new SKU("D", 15), 1)
        );

        assertEquals(280, checkoutService.calculateTotal(cart));
    }
}

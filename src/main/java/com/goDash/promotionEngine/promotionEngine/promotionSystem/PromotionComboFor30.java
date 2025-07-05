package com.goDash.promotionEngine.promotionEngine.promotionSystem;

import com.goDash.promotionEngine.promotionEngine.model.CartItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PromotionComboFor30 implements Promotion {

    @Override
    public boolean isApplicable(List<CartItem> items) {
        int cCount = items.stream()
                .filter(item -> item.getSku().getId().equalsIgnoreCase("C"))
                .mapToInt(CartItem::getQuantity)
                .sum();

        int dCount = items.stream()
                .filter(item -> item.getSku().getId().equalsIgnoreCase("D"))
                .mapToInt(CartItem::getQuantity)
                .sum();

        return cCount > 0 && dCount > 0;
    }

    @Override
    public int apply(List<CartItem> items) {
        int cTotalQty = 0;
        int dTotalQty = 0;

        for (CartItem item : items) {
            if (item.getSku().getId().equalsIgnoreCase("C")) {
                cTotalQty += item.getQuantity();
            } else if (item.getSku().getId().equalsIgnoreCase("D")) {
                dTotalQty += item.getQuantity();
            }
        }

        int comboCount = Math.min(cTotalQty, dTotalQty);
        int total = comboCount * 30;

        int cToRemove = comboCount;
        int dToRemove = comboCount;

        for (CartItem item : items) {
            if (item.getSku().getId().equalsIgnoreCase("C") && cToRemove > 0) {
                int used = Math.min(item.getQuantity(), cToRemove);
                item.setQuantity(item.getQuantity() - used);
                cToRemove -= used;
            } else if (item.getSku().getId().equalsIgnoreCase("D") && dToRemove > 0) {
                int used = Math.min(item.getQuantity(), dToRemove);
                item.setQuantity(item.getQuantity() - used);
                dToRemove -= used;
            }
        }

        return total;
    }
}

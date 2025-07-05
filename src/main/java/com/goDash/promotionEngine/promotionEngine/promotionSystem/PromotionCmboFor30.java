package com.goDash.promotionEngine.promotionEngine.promotionSystem;

import com.goDash.promotionEngine.promotionEngine.model.CartItem;

import java.util.List;

public class PromotionCmboFor30 implements Promotion {

    public boolean isApplicable(List<CartItem> items) {
        long cCount = items.stream().filter(item -> item.getSku().getId().equalsIgnoreCase("C")
                && item.getQuantity() > 0).count();
        long dCount = items.stream().filter(item -> item.getSku().getId().equalsIgnoreCase("D")
                && item.getQuantity() > 0).count();
        return cCount > 0 && dCount > 0;
    }


    public int apply(List<CartItem> items) {
        CartItem cItem = null;
        CartItem dItem = null;

        for (CartItem item : items) {
            if (item.getSku().getId().equalsIgnoreCase("C")) {
                cItem = item;
            } else if (item.getSku().getId().equalsIgnoreCase("D")) {
                dItem = item;
            }
        }

        if (cItem == null || dItem == null) {
            return 0;
        }
        int comboCount = Math.min(cItem.getQuantity(), dItem.getQuantity());
        int cRemaining = cItem.getQuantity() - comboCount;
        int dRemaining = dItem.getQuantity() - comboCount;

        int total = comboCount * 30;
        cItem.setQuantity(cRemaining);
        dItem.setQuantity(dRemaining);

        return total;
    }
}

package com.goDash.promotionEngine.promotionEngine.promotionSystem;

import com.goDash.promotionEngine.promotionEngine.model.CartItem;

import java.util.List;

public class PromotionThreeFor130 implements Promotion {


    public boolean isApplicable(List<CartItem> cartItems) {
        return cartItems.stream()
                .anyMatch(item->item.getSku().getId().equals("A")
                        && item.getQuantity()>=3);
    }


    public int apply(List<CartItem> cartItems) {
        for(CartItem item:cartItems){
            if(item.getSku().getId().equals("A")){
                int sets=item.getQuantity()/3;
                int remaining=item.getQuantity()%3;
                int total=sets*130+remaining*item.getSku().getPrice();
                item.setQuantity(0);
                return total;
            }
        }
        return 0;
    }
}

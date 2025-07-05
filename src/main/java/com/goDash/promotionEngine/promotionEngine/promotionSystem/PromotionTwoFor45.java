package com.goDash.promotionEngine.promotionEngine.promotionSystem;

import com.goDash.promotionEngine.promotionEngine.model.CartItem;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PromotionTwoFor45 implements Promotion {


    public boolean isApplicable(List<CartItem> cartItems) {
        return cartItems.stream()
                .anyMatch(item->item.getSku().getId().equals("B")
                        && item.getQuantity()>=2);
    }


    public int apply(List<CartItem> cartItems) {
        for(CartItem item:cartItems){
            if(item.getSku().getId().equals("B")){
                int sets=item.getQuantity()/2;
                int remaining=item.getQuantity()%2;
                int total=sets*45+remaining*item.getSku().getPrice();
                item.setQuantity(0);
                return total;
            }
        }
        return 0;
    }
}

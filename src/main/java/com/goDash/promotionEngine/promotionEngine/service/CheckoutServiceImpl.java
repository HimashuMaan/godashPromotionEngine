package com.goDash.promotionEngine.promotionEngine.service;

import com.goDash.promotionEngine.promotionEngine.model.CartItem;
import com.goDash.promotionEngine.promotionEngine.promotionSystem.Promotion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CheckoutServiceImpl implements CheckoutService {
    private final List<Promotion> promotions;
@Autowired
    public CheckoutServiceImpl(List<Promotion> promotions){
        this.promotions=promotions;
    }
    @Override
    public int calculateTotal(List<CartItem> cartItems) {
    int total=0;
    for(Promotion promotion:promotions){
        if(promotion.isApplicable(cartItems)){
            total+=promotion.apply(cartItems);
        }
    }
        for(CartItem item:cartItems){

                total+=item.getQuantity()*item.getSku().getPrice();

        }
        return total;

    }
}

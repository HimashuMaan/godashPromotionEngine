package com.goDash.promotionEngine.promotionEngine.controller;

import com.goDash.promotionEngine.promotionEngine.dto.CartItemDto;
import com.goDash.promotionEngine.promotionEngine.dto.CartRequest;
import com.goDash.promotionEngine.promotionEngine.model.CartItem;
import com.goDash.promotionEngine.promotionEngine.model.SKU;
import com.goDash.promotionEngine.promotionEngine.service.CheckoutService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@RestController
@RequestMapping("/api/checkout")
public class CheckoutController {

    @Autowired
    private CheckoutService checkoutService;

    private static final Map<String,Integer> skuPriceMap=new HashMap<>(){{
        put("A",50);
        put("B",30);
        put("C",20);
        put("D",15);
    }};
  @PostMapping
    public int checkout(@RequestBody CartRequest request) {
        List<CartItem> cartItems = new ArrayList<>();

        for (CartItemDto dto : request.getItems()) {
            if(!skuPriceMap.containsKey(dto.getSkuId())){
                log.error("Invalid SKU ID: {}", dto.getSkuId());
            }
            SKU sku = new SKU(dto.getSkuId(), skuPriceMap.get(dto.getSkuId()));
            cartItems.add(new CartItem(sku, dto.getQuantity()));
        }
        int total = checkoutService.calculateTotal(cartItems);
        return  total;

    }

}

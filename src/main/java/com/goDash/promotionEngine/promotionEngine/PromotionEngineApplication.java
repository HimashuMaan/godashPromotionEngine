package com.goDash.promotionEngine.promotionEngine;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(
		info = @Info(title = "Promotion Engine API", version = "1.0", description = "API for checkout and promotions")
)
@SpringBootApplication
public class PromotionEngineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PromotionEngineApplication.class, args);
	}

}


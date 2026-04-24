package com.driven.event.sismer.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateOrderRequest {

    @NotBlank(message = "customerName is required")
    private String customerName;

    @NotBlank(message = "productName is required")
    private String productName;

    @NotNull(message = "totalAmount is required")
    @Positive(message = "totalAmount must be greater than zero")
    private BigDecimal totalAmount;
}
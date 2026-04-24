package com.driven.event.sismer.api.dto.response;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderResponse(
        Long id,
        String customerName,
        String productName,
        BigDecimal totalAmount,
        String status,
        Instant createdAt
) {
}
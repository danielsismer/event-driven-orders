package com.driven.event.sismer.api.dto.request;

import java.math.BigDecimal;
import java.time.Instant;

public record OrderCreatedEvent(
        String eventType,
        Long orderId,
        String customerName,
        String productName,
        BigDecimal totalAmount,
        String status,
        Instant createdAt
) {
}
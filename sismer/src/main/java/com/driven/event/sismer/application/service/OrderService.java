package com.driven.event.sismer.application.service;

import com.driven.event.sismer.api.dto.request.CreateOrderRequest;
import com.driven.event.sismer.api.dto.request.OrderCreatedEvent;
import com.driven.event.sismer.api.dto.response.OrderResponse;
import com.driven.event.sismer.domain.entity.Order;
import com.driven.event.sismer.domain.entity.OrderStatus;
import com.driven.event.sismer.infrastructure.persistence.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderProducer orderProducer;

    @Transactional
    public OrderResponse createOrder(CreateOrderRequest request) {
        Order order = Order.builder()
                .customerName(request.getCustomerName())
                .productName(request.getProductName())
                .totalAmount(request.getTotalAmount())
                .status(OrderStatus.CREATED)
                .createdAt(Instant.now())
                .build();

        Order savedOrder = orderRepository.save(order);

        OrderCreatedEvent event = new OrderCreatedEvent(
                "order.created",
                savedOrder.getId(),
                savedOrder.getCustomerName(),
                savedOrder.getProductName(),
                savedOrder.getTotalAmount(),
                savedOrder.getStatus().name(),
                savedOrder.getCreatedAt()
        );

        orderProducer.publish(event);

        return new OrderResponse(
                savedOrder.getId(),
                savedOrder.getCustomerName(),
                savedOrder.getProductName(),
                savedOrder.getTotalAmount(),
                savedOrder.getStatus().name(),
                savedOrder.getCreatedAt()
        );
    }
}
package com.driven.event.sismer.consumer;

import com.driven.event.sismer.api.dto.request.OrderCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OrderConsumer {

    @KafkaListener(topics = "orders", groupId = "order-demo-group")
    public void consume(OrderCreatedEvent event) {
        log.info("Consumed order event: {}", event);
    }
}
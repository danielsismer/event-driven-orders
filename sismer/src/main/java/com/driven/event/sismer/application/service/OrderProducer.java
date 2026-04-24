package com.driven.event.sismer.application.service;

import com.driven.event.sismer.api.dto.request.OrderCreatedEvent;
import com.driven.event.sismer.config.KafkaTopicConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public void publish(OrderCreatedEvent event) {
        kafkaTemplate.send(KafkaTopicConfig.ORDERS_TOPIC, String.valueOf(event.orderId()), event);
    }
}
package com.driven.event.sismer.infrastructure.persistence;


import com.driven.event.sismer.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
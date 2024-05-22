package com.progtammingtechie.orderservice.repository;

import com.progtammingtechie.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends  JpaRepository<Order, Long> {
}

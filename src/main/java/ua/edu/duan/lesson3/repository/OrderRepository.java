package ua.edu.duan.lesson3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.edu.duan.lesson3.entity.OrderEntity;

public interface OrderRepository  extends JpaRepository<OrderEntity, Long> {
}

package com.it.rmu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.OrderdetailEntity;

@Repository
public interface OrderdetailRepository extends JpaRepository<OrderdetailEntity, Integer> {
    List<OrderdetailEntity> findByOrderId(Integer orderId);
}

package com.it.rmu.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {

	
	public List<OrderEntity> findByUserId(Integer userId); 
    Optional<OrderEntity> findByIdAndUserId(Integer id, Integer userId);
}

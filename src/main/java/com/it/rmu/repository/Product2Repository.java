package com.it.rmu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.ProductEntity;

@Repository
public interface Product2Repository extends JpaRepository<ProductEntity, Integer> {

}

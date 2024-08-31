package com.it.rmu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.ProductImgEntity;

@Repository
public interface ProductImg2Repository extends JpaRepository<ProductImgEntity, Integer> {
	
	public List<ProductImgEntity> findByid(Integer id);

    public List<ProductImgEntity> findByProductId(Integer productId);


}

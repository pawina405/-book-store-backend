package com.it.rmu.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.CheckEntity;



@Repository
public interface CheckRepository extends JpaRepository<CheckEntity, Integer>  {


}

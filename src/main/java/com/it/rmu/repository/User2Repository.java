package com.it.rmu.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.it.rmu.entity.UserEntity;



@Repository
public interface User2Repository extends JpaRepository<UserEntity, Integer>{

    public UserEntity findByUserName(String userName);

	public UserEntity findByUserNameAndPassword(String userName, String password);

	public void save(Optional<UserEntity> userDetail);

    @Query("select t from UserEntity t where t.roleId = 2 ")
    public List<UserEntity> findAllUser();
	
}

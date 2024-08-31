package com.it.rmu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.rmu.repository.User2Repository;


@Service
public class LoginService {

	@Autowired
    User2Repository user2Repository;


//	public LoginResponseModel authen(String username, String password) {
//
//        LoginResponseModel response = null;
//
//        UserEntity userEntity = userRepository.findByUserNameAndPassword(username, password);
//
//        if(null != userEntity) {
//            response = new LoginResponseModel();
//
//            response.setUserId(userEntity.getId());
//            response.setUserName(userEntity.getUserName());
//            response.setPassword(userEntity.getPassword());
//            response.setRoleId(userEntity.getRoleId());
//            response.setStatus(userEntity.getStatus());
//
//            UserDetailEntity userDetailEntity = userDetailRepository.findByUserId(userEntity.getId());
//            if(null != userDetailEntity) {
//                response.setFristName(userDetailEntity.getFristName());
//                response.setLastName(userDetailEntity.getLastName());
//                response.setPhone(userDetailEntity.getPhone());
//                response.setAge(userDetailEntity.getAge());
//            }
//
//        }
//
//
//        return response;
//    }


    
}

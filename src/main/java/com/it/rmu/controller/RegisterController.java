package com.it.rmu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.model.ResponseModel;
import com.it.rmu.model.UserRequestModel;
import com.it.rmu.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/register")
public class RegisterController {

	@Autowired
    private UserService userService;

//    @GetMapping("/getById")
//    public ResponseModel getById(@RequestParam(name = "userId") Integer Id) {
//
//        ResponseModel response = new ResponseModel();
//
//        try {
//            // service
//            response.setData(userService.getById(Id));
//            response.setStatus("SUCCESS");
//        } catch (Exception e) {
//            // TODO: handle exception
//            response.setStatus("ERROR");
//            response.setMessage(e.getMessage());
//        }
//
//        return response;
//    }
//	
//
//    
//    @PutMapping("/update/{userId}")
//    public void update(@RequestBody UserRequestModel request, @PathVariable Integer Id) {
//
//        userService.update(request);
//     
//
//    }
//    
//    @DeleteMapping("/delete")
//    public void delete(@RequestParam(name = "Id") Integer Id) {
//
//    	userService.delete(Id);
//
//    }
	
}
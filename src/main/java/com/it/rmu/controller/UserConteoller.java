package com.it.rmu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.entity.UserEntity;
import com.it.rmu.model.ResponseModel;
import com.it.rmu.model.UserRequestModel;
import com.it.rmu.model.UserResponseModel;
import com.it.rmu.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/user")
public class UserConteoller {
	
	@Autowired 
	UserService userService;
	
	@PostMapping("/save")
	public ResponseEntity<Object> saveuser(@RequestBody UserRequestModel requestModel) {
		//TODO: process POST request
		
		return userService.save(requestModel);
		
	}
	
	@GetMapping("/getAll")
	public List<UserResponseModel> getAll() {
		return userService.getAll();
	}
	
  @GetMapping("/getById")
  public UserResponseModel getById(@RequestParam(name= "Id") Integer id) {

      return userService.getById(id);
  }
	
    @PutMapping("/update")
  public UserEntity update(@RequestBody UserRequestModel request) {
    return  userService.update(request);
  } 
  
  @DeleteMapping("/delete")
  public void delete(@RequestParam(name = "Id") Integer id) {
      userService.delete(id);
  }
  
  @PostMapping("/register")
  public ResponseModel save(@RequestBody UserRequestModel request) {
	     ResponseModel response = new ResponseModel();

	      try {
	          // service
	          response.setData(userService.registerUser(request));
	          response.setStatus("SUCCESS");
	      } catch (Exception e) {
	          // TODO: handle exception
	          response.setStatus("ERROR");
	          response.setMessage(e.getMessage());
	      }

	      return response;  
  }
  
  @GetMapping("/login")
  public ResponseModel login(@RequestParam(name = "userName") String username, @RequestParam(name = "password") String password) {
      ResponseModel response = new ResponseModel();

      try {
          // service
          response.setData(userService.loginUser(username, password));
          response.setStatus("SUCCESS");
      } catch (Exception e) {
          // TODO: handle exception
          response.setStatus("ERROR");
          response.setMessage(e.getMessage());
      }

      return response;
  }
  
//  @GetMapping("/login")
//  public ResponseModel loginUser(@RequestParam(name = "userName") String username, @RequestParam(name = "password") String password) {
//      ResponseModel response = new ResponseModel();
//
//      try {
//          // service
//          response.setData(userService.authen(username, password));
//          response.setStatus("SUCCESS");
//      } catch (Exception e) {
//          // TODO: handle exception
//          response.setStatus("ERROR");
//          response.setMessage(e.getMessage());
//      }
//
//      return response;
//  }
	

  

}

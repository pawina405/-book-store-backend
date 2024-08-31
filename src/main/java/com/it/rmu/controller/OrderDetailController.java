package com.it.rmu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.entity.OrderdetailEntity;
import com.it.rmu.model.OrderdetailRequestModel;
import com.it.rmu.model.OrderdetailResponseModel;

import com.it.rmu.service.OrderdetailService;

@RestController
@RequestMapping("/orderdetail")
public class OrderDetailController {

	@Autowired 
	OrderdetailService orderdetailService ;
	
	@PostMapping("/save")
	public OrderdetailEntity save(@RequestBody OrderdetailRequestModel requestModel) {
		//TODO: process POST request
		
		return orderdetailService.save(requestModel);
	}
	
	@GetMapping("/getAll")
	public List<OrderdetailResponseModel> getAll() {
		return orderdetailService.getAll();
	}
	
  @GetMapping("/getById")
  public OrderdetailResponseModel getById(@RequestParam(name = "id") Integer id) {

      return orderdetailService.getById(id);
  }
	
    @PutMapping("/update")
  public void update(@RequestBody OrderdetailRequestModel request) {
    	orderdetailService.update(request);
  } 
  
  @DeleteMapping("/delete")
  public void delete(@RequestParam(name = "id") Integer id) {
	  orderdetailService.delete(id);
  }
  
}

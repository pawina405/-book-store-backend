package com.it.rmu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.entity.OrderEntity;
import com.it.rmu.model.OrderRequestModel;
import com.it.rmu.model.OrderResponseModel;

import com.it.rmu.service.OrderService;


@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired 
	OrderService orderService ;
	
	@PostMapping("/save")
	public OrderEntity save(@RequestBody OrderRequestModel requestModel) {
		//TODO: process POST request
		
		return orderService.save(requestModel);
	}
	
	@PostMapping("/saveOrder")
	public OrderEntity saveOrder(@RequestBody OrderRequestModel requestModel) {
		//TODO: process POST request
		
		return orderService.saveOrder(requestModel);
	}
	
	@GetMapping("/getAll")
	public List<OrderResponseModel> getAll() {
		return orderService.getAll();
	}
	
  @GetMapping("/getById")
  public OrderResponseModel getById(@RequestParam(name = "id") Integer id) {

      return orderService.getById(id); 
  }
	
    @PutMapping("/update")
  public void update(@RequestBody OrderRequestModel request) {
    	orderService.update(request);
  } 
  
  
  @DeleteMapping("/delete/{id}")
  public ResponseEntity<Object> delete(@PathVariable(name = "id") Integer id) {
      return orderService.deleteOrder(id);
  }
  @GetMapping("/getorderByUserId/{userId}")
  public ResponseEntity<Object> getOrderByUserId(@PathVariable(name = "userId") Integer userId) {
      return orderService.findOderByUserId(userId);
  }

  @GetMapping("/getAllOrders")
  public ResponseEntity<Object> getAllOrders() {
      return orderService.getAllOrders();
  }
  
  @DeleteMapping("/cancelOrder/{orderId}")
  public ResponseEntity<Object> cancelOrder(@PathVariable Integer orderId, @RequestParam Integer userId) {
      return orderService.cancelOrder(orderId, userId);
  }
  @GetMapping("/getordersByUserId/{userId}")
  public ResponseEntity<Object> getOrdersByUserId(@PathVariable(name = "userId") Integer userId) {
      return orderService.getOrdersByUserId(userId);
  }
  
}

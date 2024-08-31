package com.it.rmu.service;
 
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.it.rmu.entity.OrderdetailEntity;
import com.it.rmu.model.OrderdetailRequestModel;
import com.it.rmu.model.OrderdetailResponseModel;
import com.it.rmu.repository.OrderdetailRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderdetailService {

	@Autowired
	private OrderdetailRepository orderdetailRepository;
	
	public OrderdetailResponseModel getById(Integer Id) {
		
		OrderdetailResponseModel response = null;
		
		Optional<OrderdetailEntity> entity = orderdetailRepository.findById(Id);
		
		if(entity.isPresent()) {
			OrderdetailEntity orderdetail = entity.get();
			response = new OrderdetailResponseModel();
			response.setId(orderdetail.getId());
			response.setOrderId(orderdetail.getOrderId());
			response.setProductId(orderdetail.getProductId());
			response.setUnitPrice(orderdetail.getUnitPrice());
			response.setQuantity(orderdetail.getQuantity());
		}

		return response;
		
	}
	
	public List<OrderdetailResponseModel> getAll() {
		
		List<OrderdetailResponseModel> response = null;
		
		List<OrderdetailEntity> entitys = orderdetailRepository.findAll();
		
		if(null != entitys) {
			response = new ArrayList<>();
			for(OrderdetailEntity orderdetail2 : entitys) {
				
				OrderdetailResponseModel object = new OrderdetailResponseModel();
				object.setId(orderdetail2.getId());
				object.setOrderId(orderdetail2.getOrderId());
				object.setProductId(orderdetail2.getProductId());
				object.setUnitPrice(orderdetail2.getUnitPrice());
				object.setQuantity(orderdetail2.getQuantity());
							
				response.add(object);
			}

		}

		return response;
		
	}
	
	@Transactional
	public OrderdetailEntity save(OrderdetailRequestModel requestModel){
		if(null != requestModel) {	
			OrderdetailEntity orderdeail = new OrderdetailEntity();
			orderdeail.setOrderId(requestModel.getOrderId());
			orderdeail.setProductId(requestModel.getProductId());
			orderdeail.setUnitPrice(requestModel.getUnitPrice());
			orderdeail.setQuantity(requestModel.getQuantity());
			
			return	orderdetailRepository.save(orderdeail);
		
	}	
		return null;
		
	}
	
	public void update(OrderdetailRequestModel request) {

		  if(null != request) {
		      if(null != request.getId()) {

		          Optional<OrderdetailEntity> orderdetailEntity =  orderdetailRepository.findById(request.getId());

		          if(orderdetailEntity.isPresent()) {
		              OrderdetailEntity Entity4 = orderdetailEntity.get();
		              Entity4.setOrderId(request.getOrderId());
		              Entity4.setProductId(request.getProductId());
		              Entity4.setUnitPrice(request.getUnitPrice());
		              Entity4.setQuantity(request.getQuantity());
		              
		              orderdetailRepository.save(Entity4);
		          }
		      }
		  }
		}

		public void delete(Integer id) {

		  orderdetailRepository.deleteById(id);

		}
		
		public ResponseEntity<Object> saveOrderdetailAndOrderId(Integer id, OrderdetailRequestModel request) {
			if(request != null) {
				OrderdetailEntity entity = new OrderdetailEntity();
				entity.setOrderId(request.getOrderId());
				entity.setProductId(request.getProductId());
				entity.setQuantity(request.getQuantity());
				entity.setUnitPrice(request.getUnitPrice());
				orderdetailRepository.save(entity);
				return ResponseEntity.ok("Orderdetail added successfully");
			}
			return ResponseEntity.ok("Failed, Please Try Again");
		}
		


}

package com.it.rmu.service;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.it.rmu.entity.OrderEntity;
import com.it.rmu.entity.OrderdetailEntity;
import com.it.rmu.model.OrderRequestModel;
import com.it.rmu.model.OrderResponseModel;
import com.it.rmu.model.OrderdetailResponseModel;
import com.it.rmu.repository.OrderRepository;
import com.it.rmu.repository.OrderdetailRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderdetailRepository orderDetailRepository;
	
	public OrderResponseModel getById(Integer Id) {
		
		OrderResponseModel response = null;
		
		Optional<OrderEntity> entity = orderRepository.findById(Id);
		
		if(entity.isPresent()) {
			OrderEntity order = entity.get();
			response = new OrderResponseModel();
			
			response.setId(order.getId());
			response.setTotal(order.getTotal());
			response.setStatus(order.getStatus());
			response.setUserId(order.getUserId());
			
		}

		return response;
		
	}
	
	public List<OrderResponseModel> getAll() {
		
		List<OrderResponseModel> response = null;
		
		List<OrderEntity> entitys = orderRepository.findAll();
		
		if(null != entitys) {
			response = new ArrayList<>();
			for(OrderEntity order : entitys) {
				
				OrderResponseModel object = new OrderResponseModel();
				
				object.setId(order.getId());
				object.setUserId(order.getUserId());
				object.setTotal(order.getTotal());
				object.setStatus(order.getStatus());				
				response.add(object);
			}

		}

		return response; 
		
	}
	
	@Transactional
	public OrderEntity save(OrderRequestModel orderRequest){
		
		
		if(null != orderRequest) {
			OrderEntity orderEntity = new OrderEntity();
			
			orderEntity.setTotal(orderRequest.getTotal());
			orderEntity.setStatus(orderRequest.getStatus());
			orderEntity.setCreateDate(new Date());
			orderEntity.setUserId(orderRequest.getUserId());
			return orderRepository.save(orderEntity);
		}
		
		
		return null;
		
	}
	
	@Transactional
	public OrderEntity saveOrder(OrderRequestModel orderRequest) {
		if(null != orderRequest) {
			OrderEntity orderEntity = new OrderEntity();
			
			orderEntity.setCreateDate(new Date());
			orderEntity.setUserId(orderRequest.getUserId());
			orderEntity.setStatus(orderRequest.getStatus());
			orderEntity.setTotal(orderRequest.getTotal());
			
			return orderRepository.save(orderEntity);
		}
		return null;
	}
	
	public void update(OrderRequestModel request) {

		  if(null != request) {
		      if(null != request.getId()) {

		          Optional<OrderEntity> orderEntity =  orderRepository.findById(request.getId());

		          if(orderEntity.isPresent()) {
		              OrderEntity Entity = orderEntity.get();
		              Entity.setTotal(request.getTotal());
		              Entity.setStatus(request.getStatus());
		              
		              orderRepository.save(Entity);
		          }
		      }
		  }
		}

		public void delete(Integer id) {

		  orderRepository.deleteById(id);

		}
		
	public ResponseEntity<Object> findOderByUserId(Integer userId) {
			
			List<OrderEntity> entities = orderRepository.findByUserId(userId);
			
			List<OrderResponseModel> response = null;
			
			if(entities != null) {
				 
				response = new ArrayList<>();
				
				for(OrderEntity entity : entities) {
					
					OrderResponseModel model = new OrderResponseModel();
					
					model.setId(entity.getId());
					model.setUserId(entity.getUserId());
					model.setTotal(entity.getTotal());
					model.setStatus(entity.getStatus());
					model.setCreateDate(new Date());
					response.add(model);
					
				}
			}
			return ResponseEntity.ok(response);
		}
	
	public ResponseEntity<Object> getOrdersByUserId(Integer userId) {
	    // ดึงข้อมูล Order ตาม userId
	    List<OrderEntity> orderEntities = orderRepository.findByUserId(userId);

	    List<OrderResponseModel> response = new ArrayList<>();
	    
	    if (orderEntities != null) {
	        for (OrderEntity orderEntity : orderEntities) {
	            OrderResponseModel orderResponseModel = new OrderResponseModel();
	            orderResponseModel.setId(orderEntity.getId());
	            orderResponseModel.setUserId(orderEntity.getUserId());
	            orderResponseModel.setTotal(orderEntity.getTotal());
	            orderResponseModel.setStatus(orderEntity.getStatus());
	            orderResponseModel.setCreateDate(orderEntity.getCreateDate());

	            // ดึงข้อมูล OrderDetail ตาม orderId
	            List<OrderdetailEntity> orderDetailEntities = orderDetailRepository.findByOrderId(orderEntity.getId());
	            List<OrderdetailResponseModel> orderDetailResponseModels = new ArrayList<>();
	            
	            for (OrderdetailEntity orderDetailEntity : orderDetailEntities) {
	                OrderdetailResponseModel orderDetailResponseModel = new OrderdetailResponseModel();
	                orderDetailResponseModel.setId(orderDetailEntity.getId());
	                orderDetailResponseModel.setOrderId(orderDetailEntity.getOrderId());
	                orderDetailResponseModel.setProductId(orderDetailEntity.getProductId());
	                orderDetailResponseModel.setQuantity(orderDetailEntity.getQuantity());
	                orderDetailResponseModel.setUnitPrice(orderDetailEntity.getUnitPrice());
	                orderDetailResponseModels.add(orderDetailResponseModel);
	            }

	            // เพิ่ม OrderDetail ลงใน OrderResponseModel
	            orderResponseModel.setOrderDetails(orderDetailResponseModels);
	            response.add(orderResponseModel);
	        }
	    }
	    return ResponseEntity.ok(response);
	}

	public ResponseEntity<Object> getAllOrders() {
	    // ดึงข้อมูล Order ทั้งหมด
	    List<OrderEntity> orderEntities = orderRepository.findAll();

	    List<OrderResponseModel> response = new ArrayList<>();
	    
	    if (orderEntities != null) {
	        for (OrderEntity orderEntity : orderEntities) {
	            OrderResponseModel orderResponseModel = new OrderResponseModel();
	            orderResponseModel.setId(orderEntity.getId());
	            orderResponseModel.setUserId(orderEntity.getUserId());
	            orderResponseModel.setTotal(orderEntity.getTotal());
	            orderResponseModel.setStatus(orderEntity.getStatus());
	            orderResponseModel.setCreateDate(orderEntity.getCreateDate());

	            // ดึงข้อมูล OrderDetail ตาม orderId
	            List<OrderdetailEntity> orderDetailEntities = orderDetailRepository.findByOrderId(orderEntity.getId());
	            List<OrderdetailResponseModel> orderDetailResponseModels = new ArrayList<>();
	            
	            for (OrderdetailEntity orderDetailEntity : orderDetailEntities) {
	                OrderdetailResponseModel orderDetailResponseModel = new OrderdetailResponseModel();
	                orderDetailResponseModel.setId(orderDetailEntity.getId());
	                orderDetailResponseModel.setOrderId(orderDetailEntity.getOrderId());
	                orderDetailResponseModel.setProductId(orderDetailEntity.getProductId());
	                orderDetailResponseModel.setQuantity(orderDetailEntity.getQuantity());
	                orderDetailResponseModel.setUnitPrice(orderDetailEntity.getUnitPrice());
	                orderDetailResponseModels.add(orderDetailResponseModel);
	            }

	            // เพิ่ม OrderDetail ลงใน OrderResponseModel
	            orderResponseModel.setOrderDetails(orderDetailResponseModels);
	            response.add(orderResponseModel);
	        }
	    }
	    return ResponseEntity.ok(response);
	}

    @Transactional
    public ResponseEntity<Object> deleteOrder(Integer orderId) {
        Optional<OrderEntity> orderEntity = orderRepository.findById(orderId);
        if (orderEntity.isPresent()) {
            orderRepository.delete(orderEntity.get());
            return ResponseEntity.ok("Order deleted successfully");
        } else {
            return ResponseEntity.status(404).body("Order not found");
        }
    }
    
    @Transactional
    public ResponseEntity<Object> cancelOrder(Integer orderId, Integer userId) {
        Optional<OrderEntity> orderEntity = orderRepository.findByIdAndUserId(orderId, userId);
        if (orderEntity.isPresent()) {
            orderRepository.delete(orderEntity.get());
            return ResponseEntity.ok("Order cancelled successfully");
        } else {
            return ResponseEntity.status(404).body("Order not found or not authorized to cancel");
        }
    }
}

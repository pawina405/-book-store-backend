package com.it.rmu.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.it.rmu.entity.PaymentEntity;
import com.it.rmu.model.PaymentRequestModel;
import com.it.rmu.model.PaymentResponseModel;
import com.it.rmu.model.RegisterPaymentRequestModel;
import com.it.rmu.repository.PaymentRepository;

@Service
public class PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	public PaymentEntity savePayment(PaymentRequestModel request) {
		if (request != null) {
			PaymentEntity entity = new PaymentEntity();
			entity.setCreateDate(new Date());
			entity.setOrderId(request.getOrderId());
			entity.setPaymentAmount(request.getPaymentAmount());
			entity.setPaymentMethod(request.getPaymentMethod());
			entity.setSlip(request.getSlip());
			entity.setApprovedBy(request.getApprovedBy());
			entity.setStatus(request.getStatus());
			paymentRepository.save(entity);
			return paymentRepository.save(entity);
		} else {
			return null;
		}
	}

	public List<PaymentResponseModel> getAllPayment() {
		List<PaymentEntity> entities = paymentRepository.findAll();
		List<PaymentResponseModel> response = null;
		if (entities != null) {
			response = new ArrayList<>();
			for (PaymentEntity entity : entities) {
				PaymentResponseModel model = new PaymentResponseModel();
				model.setCreateDate(new Date());
				model.setId(entity.getId());
				model.setOrderId(entity.getOrderId());
				model.setPaymentAmount(entity.getPaymentAmount());
				model.setPaymentMethod(entity.getPaymentMethod());
				model.setApprovedBy(entity.getApprovedBy());
				model.setStatus(entity.getStatus());
				model.setSlip(entity.getSlip());
				response.add(model);
			}
		}
		return response;
	}

	public PaymentResponseModel getPaymentById(Integer id) {
		Optional<PaymentEntity> entity = paymentRepository.findById(id);
		PaymentResponseModel model = null;
		if (entity.isPresent()) {
			PaymentEntity payment = entity.get();
			model = new PaymentResponseModel();
			model.setCreateDate(new Date());
			model.setId(payment.getId());
			model.setOrderId(payment.getOrderId());
			model.setPaymentAmount(payment.getPaymentAmount());
			model.setPaymentMethod(payment.getPaymentMethod());
			model.setApprovedBy(payment.getApprovedBy());
			model.setStatus(payment.getStatus());
			return model;
		}
		return null;
	}

	public PaymentEntity updatePayment(Integer paymentId, PaymentRequestModel request) {
		Optional<PaymentEntity> entity = paymentRepository.findById(paymentId);
		if (entity.isPresent()) {
			PaymentEntity payment = entity.get();
			payment.setCreateDate(new Date());
			payment.setPaymentAmount(request.getPaymentAmount());
			payment.setPaymentMethod(request.getPaymentMethod());
			payment.setSlip(request.getSlip());
			payment.setApprovedBy(request.getApprovedBy());
			payment.setStatus(request.getStatus());
			return payment;
		}
		return null;
	}

	public void deletePayment(Integer id) {
		Optional<PaymentEntity> entity = paymentRepository.findById(id);
		if (entity.isPresent()) {
			PaymentEntity payment = entity.get();
			paymentRepository.delete(payment);
		}
	}

	public PaymentEntity registerPayment(RegisterPaymentRequestModel request) throws IOException {
		if (request != null) {
			PaymentEntity entity = new PaymentEntity();
			entity.setCreateDate(new Date());
			entity.setOrderId(request.getOrderId());
			entity.setPaymentAmount(request.getPaymentAmount());
			entity.setPaymentMethod(request.getPaymentMethod());
			if (request != null && !request.getFile().isEmpty()) {
				entity.setSlip(Base64.getEncoder().encodeToString(request.getFile().getBytes()));
			}

			entity.setApprovedBy(request.getApprovedBy());
			entity.setStatus(request.getStatus());
			paymentRepository.save(entity);
			return paymentRepository.save(entity);
		} else {
			return null;
		}
	}

// 	public PaymentEntity UploadsSlip(PaymentResponseModel request) throws IOException {
//		if (request != null) {
//			PaymentEntity entity = new PaymentEntity();
//			entity.setCreateDate(new Date());
//			entity.setOrderId(request.getOrderId());
//			entity.setPaymentAmount(request.getPaymentAmount());
//			entity.setPaymentMethod(request.getPaymentMethod());
//			entity.setApprovedBy(request.getApprovedBy());
//			entity.setStatus(request.getStatus());
//			if (request.getImage() != null) {
//				entity.setSlip(Base64.getEncoder().encodeToString(request.getImage().getBytes()));
//			}
//			paymentRepository.save(entity);
//			return paymentRepository.save(entity);
//		} else {
//			return null;
//		}
//	}

//	public PaymentResponseModel getById(Integer Id) {
//		
//		PaymentResponseModel response = null;
//		
//		Optional<PaymentEntity> payment = paymentRepository.findById(Id);
//		
//		if(payment.isPresent()) {
//			PaymentEntity paymentEntity = payment.get();
//			response = new PaymentResponseModel();
//			
//			response.setId(paymentEntity.getId());
//			response.setOrderId(paymentEntity.getOrderId());
//			response.setPaymentAmount(paymentEntity.getPaymentAmount());
//			response.setStatus(paymentEntity.getStatus());
//
//			
//		}
//
//		return response;
//		
//	}
//	
//	public List<PaymentResponseModel> getAll() {
//		
//		List<PaymentResponseModel> response = null;
//		
//		List<PaymentEntity> entitys = paymentRepository.findAll();
//		
//		if(null != entitys) {
//			response = new ArrayList<>();
//			for(PaymentEntity payment : entitys) {
//				
//				PaymentResponseModel object = new PaymentResponseModel();
//				
//				object.setId(payment.getId());
//				object.setOrderId(payment.getOrderId());
//				object.setPaymentAmount(payment.getPaymentAmount());
//				object.setStatus(payment.getStatus());
//
//
//			
//				response.add(object);
//			}
//
//		}
//
//		return response;
//		
//	}
//	
//	@Transactional
//	public Integer save(PaymentRequestModel paymentRequest) {
//		
//		Integer response = null;
//		
//		if(null != paymentRequest) {
//			PaymentEntity paymentEntity = new PaymentEntity();
//			paymentEntity.setOrderId(paymentRequest.getOrderId());
//			paymentEntity.setPaymentAmount(paymentRequest.getPaymentAmount());
//			paymentEntity.setStatus(paymentRequest.getStatus());
//			paymentEntity = paymentRepository.save(paymentEntity);
//			response = paymentEntity.getId();
//			
//		}
//		
//		
//		return response;
//		
//	}
//	
//
//	
//	
//	public void update(PaymentRequestModel request) {
//
//		  if(null != request) {
//		      if(null != request.getId()) {
//
//		          Optional<PaymentEntity> Entity =  paymentRepository.findById(request.getId());
//
//		          if(Entity.isPresent()) {
//		        	  PaymentEntity Entity5 = Entity.get();
//		        	  
//		        	  Entity5.setPaymentAmount(request.getPaymentAmount());
//		  			Entity5.setStatus(request.getStatus());
//		              
//		              paymentRepository.save(Entity5);
//		          }
//		      }
//		  }
//		}
//
//		public void delete(Integer id) {
//
//        paymentRepository.deleteById(id);
//
//		}

}

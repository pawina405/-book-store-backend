package com.it.rmu.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.entity.PaymentEntity;
import com.it.rmu.model.PaymentRequestModel;
import com.it.rmu.model.PaymentResponseModel;
import com.it.rmu.model.RegisterPaymentRequestModel;
import com.it.rmu.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {

	@Autowired 
	PaymentService paymentService ;
	
	@PostMapping("/create")
    public PaymentEntity savePayment(@RequestBody PaymentRequestModel request) {
        return paymentService.savePayment(request);
    }

    @GetMapping("/getAll")
    public List<PaymentResponseModel> getAllPayment() {
        return paymentService.getAllPayment();
    }

    @GetMapping("/getById/{paymentId}")
    public PaymentResponseModel getPaymentById(@PathVariable(name = "paymentId") Integer id) {
        return paymentService.getPaymentById(id);
    }

    @PutMapping("/update/{paymentId}")
    public PaymentEntity updatePayment(@PathVariable(name = "paymentId") Integer id,
            @RequestBody PaymentRequestModel request) {
        return paymentService.updatePayment(id, request);
    }

    @DeleteMapping("/delete/{paymentId}")
    public void deletePayment(@PathVariable(name = "paymentId") Integer id) {
        paymentService.deletePayment(id);
    }

 
   
	@PostMapping("/payment")
    public PaymentEntity Payment(@ModelAttribute RegisterPaymentRequestModel request) throws IOException {
        return paymentService.registerPayment(request);
    }
    
//    @PostMapping("/registerPayment")
//    public PaymentEntity registerPayment(@ModelAttribute PaymentRequestModel request) throws IOException {
//        return paymentService.UploadsSlip(request);
//    }
    
    
	
//	@PostMapping("/save")
//	public ResponseModel save(@RequestBody PaymentRequestModel requestModel) {
//		//TODO: process POST request
//		
//      ResponseModel response = new ResponseModel();
//
//      try {
//          // service
//          response.setData(paymentService.save(requestModel));
//          response.setStatus("SUCCESS");
//      } catch (Exception e) {
//          // TODO: handle exception
//          response.setStatus("ERROR");
//          response.setMessage(e.getMessage());
//      }
//
//      return response;
//	}
//	
//	
//	@GetMapping("/getAll")
//	public List<PaymentResponseModel> getAll() {
//		return paymentService.getAll();
//	}
//	
//  @GetMapping("/getById")
//  public PaymentResponseModel getById(@RequestParam(name = "id") Integer id) {
//
//      return paymentService.getById(id);
//  }
//	
//    @PutMapping("/update")
//  public void update(@RequestBody PaymentRequestModel request) {
//    	paymentService.update(request);
//  } 
//  
//  @DeleteMapping("/delete")
//  public void delete(@RequestParam(name = "id") Integer id) {
//	  paymentService.delete(id);
//  }
}

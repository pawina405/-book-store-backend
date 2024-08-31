package com.it.rmu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import com.it.rmu.model.ResponseModel;

import com.it.rmu.service.ProductTypeService;


@RestController
@RequestMapping("/productType")
public class ProductTypeController {

	@Autowired 
	ProductTypeService productTypeService;
	
	
	@GetMapping("/getProductTypeAll")
	public ResponseModel getProductTypeAll() {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(productTypeService.getAll());
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
 
 

}

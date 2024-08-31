package com.it.rmu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.it.rmu.model.ResponseModel;
import com.it.rmu.service.CheckService;


@RestController
@RequestMapping("/check")
public class CheckController {

	@Autowired
	private CheckService checkService ;
	
	@GetMapping("/getById")
	public ResponseModel getById(@RequestParam(name = "Id") Integer Id) {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(checkService.getById(Id));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	
	@GetMapping("/getAll")
	public ResponseModel getAll() {
		ResponseModel response = new ResponseModel();
		
		try {
			// service
			response.setData(checkService.getAll());
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}

		return response;
	}
	@PostMapping(value =("/saveImage/{id}") , consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseModel saveImage(@RequestParam("file") MultipartFile file, @PathVariable Integer id) {
		
		ResponseModel response = new ResponseModel(); 
		
		try {
			response.setData(checkService.save(file, id));
			response.setStatus("SUCCESS");
		} catch (Exception e) {
			// TODO: handle exception
			response.setStatus("ERROR");
			response.setMessage(e.getMessage());
		}
		
		return response;
	}
	
	  @DeleteMapping("/delete")
	  public void delete(@RequestParam(name = "id") Integer id) {
	      checkService.delete(id);
	  }

}

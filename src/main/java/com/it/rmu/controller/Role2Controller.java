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

import com.it.rmu.model.RoleRequestModel;
import com.it.rmu.model.RoleResponseModel;
import com.it.rmu.service.Role2Service;



@RestController
@RequestMapping("/role2")
public class Role2Controller {
	
	@Autowired
    private Role2Service role2Service;
	
    @GetMapping("/getById")
  public RoleResponseModel getById(@RequestParam(name ="id") Integer id) {

      return role2Service.getById(id);
  }
  
  @GetMapping("/getAll")
  public List<RoleResponseModel> getAll() {

      return role2Service.getAll();
  }
  
  @PostMapping("/save")
  public void save(@RequestBody RoleRequestModel request) {
      role2Service.save(request);
  }
  
  @PutMapping("/update")
  public void update(@RequestBody RoleRequestModel request) {
      role2Service.update(request);
  } 
  
  @DeleteMapping("/delete")
  public void delete(@RequestParam(name = "id") Integer id) {
      role2Service.delete(id);
  }


}

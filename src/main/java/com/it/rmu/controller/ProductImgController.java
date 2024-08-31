package com.it.rmu.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RestController;

import com.it.rmu.model.ProductImgRequestModel;
import com.it.rmu.model.ProductImgResponseModel;
import com.it.rmu.service.ProductImgService;




@RestController
@RequestMapping("/productimg")
public class ProductImgController {

	@Autowired
    private ProductImgService productImgService;

    @PostMapping("/create")
    public ResponseEntity<Object> saveProductImg(@RequestBody ProductImgRequestModel path) throws IOException {
        return productImgService.saveProductImg(path);
    }

    @GetMapping("/getAll")
    public List<ProductImgResponseModel> getAllProductPicture() {
        return productImgService.getAllProductImg();
    }

    @GetMapping("/getById/{productImgId}")
    public ResponseEntity<Object> getProductPictureById(@PathVariable(name = "productImgId") Integer id) {
        return productImgService.getProductImgById(id);
    }

    @PutMapping("/update/{productImgId}")
    public ResponseEntity<Object> updateProductPicture(@PathVariable(name = "productImgId") Integer id,
            @RequestBody ProductImgResponseModel path) {
        return productImgService.updateProductImg(id, path);
    }

    @DeleteMapping("/delete/{productImgId}")
    public ResponseEntity<Object> deleteProductPicture(@PathVariable(name = "productImgId") Integer id) {
        return productImgService.deleteProductImg(id);
    }

    @GetMapping("/getByProductId/{productId}")
    public List<ProductImgRequestModel> getProductPictureByProductId(
            @PathVariable(name = "productId") Integer productId) {
        return productImgService.getProductImgByProductId(productId);
    }
	
}

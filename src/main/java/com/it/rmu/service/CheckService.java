package com.it.rmu.service;

import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.it.rmu.entity.CheckEntity;
import com.it.rmu.entity.ProductImgEntity;
import com.it.rmu.model.CheckResponseModel;

import com.it.rmu.repository.CheckRepository;
import com.it.rmu.utils.ImgUtils;

import jakarta.transaction.Transactional;

@Service
public class CheckService {

	@Autowired
	private CheckRepository checkRepository;
	
	  public CheckResponseModel getById(Integer id) {
		  // ดึงข้อมูล
		  Optional<CheckEntity> checkEntity =  checkRepository.findById(id);

		  CheckResponseModel response = null;


		  if(checkEntity.isPresent()) {
		      response = new CheckResponseModel();
		      // มีข้อมูลที่ได้จาก Table role ของ DB
		      CheckEntity entity = checkEntity.get();

		      // เอาข้อมูลที่ได้จาก Table มา Map เข้ากับ Object Response 
		      response.setId(entity.getId());
		      response.setCheckImg(entity.getCheckImg());
		      response.setPaymentId(entity.getPaymentId());

		  }
			
		  return response;
		}


		public List<CheckResponseModel> getAll(){

		  List<CheckEntity> checkEntityList = checkRepository.findAll();
		  List<CheckResponseModel> responseList = null;
		  if(null != checkEntityList) {
		      responseList = new ArrayList<>();

		      for(CheckEntity checkEntity : checkEntityList) {
		          CheckResponseModel Obj = new CheckResponseModel();
		          Obj.setId(checkEntity.getId());
		          Obj.setCheckImg(checkEntity.getCheckImg());
		          Obj.setPaymentId(checkEntity.getPaymentId());

		          responseList.add(Obj);
		      }
		  }

		  return responseList;
		  
		  
		}

		@Transactional
		public Integer save(MultipartFile file, Integer id) throws IOException {
			Integer response = null;
			if(null != file && null != id) {
				CheckEntity Img = new CheckEntity();
//				String preFixNameFile = ImgUtils.genaratePrefixFile();
//				String genarateFileName = ImgUtils.genarateFileName() +ImgUtils.subStrFileName(file.getOriginalFilename());
//				String fileName = ImgUtils.concatStr(preFixNameFile, genarateFileName);

				Img.setCheckImg(ImgUtils.compressImage(file.getBytes()));
				Img.setPaymentId(id);

				Img = checkRepository.save(Img);
				response = Img.getId();
				

			}
			return response;
		}
		

		public void delete(Integer id) {

		  checkRepository.deleteById(id);

		}
}

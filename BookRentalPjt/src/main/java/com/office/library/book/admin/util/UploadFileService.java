package com.office.library.book.admin.util;

import java.io.File;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileService {
	public String upload(MultipartFile file) {
        
	      boolean result = false;
	      
	      // File 저장
	      String fileOriName = file.getOriginalFilename();
	      String fileExtension = 
	            fileOriName.substring(fileOriName.lastIndexOf("."), 
	                  fileOriName.length());
	      String uploadDir = "C:\\library\\upload\\";
	      
	    //UUID : 네트워크 상에서 서로 모르는 개체들을 
	      //식별하고 구별하기 위해서는 각각의 고유한 이름이 필요
	      //범용 고유 식별자를 의미하며 중복이 되지 않는 
	      //유일한 값을 구성하고자 할때 주로 사용
	      /*
	       UUID는 16바이트(128비트) 크기의 숫자로 표현되며, 
	       보통 8-4-4-4-12의 5개의 그룹으로 나누어져 
	       총 36자의 문자열로 나타남. 예를 들어, 
	       550e8400-e29b-41d4-a716-446655440000와 같은 형식을 
	       가짐.
	       */
	      
	      UUID uuid = UUID.randomUUID();
	      String uniqueName = uuid.toString().replaceAll("-", "");
	      
	      File saveFile = new File(uploadDir + "\\" + uniqueName + fileExtension);
	      
	      if (!saveFile.exists())
	         saveFile.mkdirs();
	      
	      try {
	         file.transferTo(saveFile);
	         result = true;
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	         
	      }
	      
	      if (result) {
	         System.out.println("[UploadFileService] FILE UPLOAD SUCCESS!!");
	         return uniqueName + fileExtension;
	         
	      } else {
	         System.out.println("[UploadFileService] FILE UPLOAD FAIL!!");
	         return null;
	         
	      }
	      
	      
	   }

}

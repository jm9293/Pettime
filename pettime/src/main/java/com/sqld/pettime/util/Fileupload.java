package com.sqld.pettime.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;



public class Fileupload {

	
	public static void proflieImgupload(HttpServletRequest request, MultipartFile multipartFile ,String filepath, String userID) {

		File file = new File(request.getRealPath(filepath)+"/"+userID+".jpg"); 
		try {
			if(!file.exists()) {
			multipartFile.transferTo(file);
			}else {
				file.delete();
				multipartFile.transferTo(file);
			}
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}

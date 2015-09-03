package com.tja.frame.web.fore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/")
public class UploadController {

	//private static String UPLOAD_PATH = "upload/";
	
	@RequestMapping(value="/upload",produces="application/json;charset=UTF-8")
	@ResponseBody
	public UploadResult uploadAttachment(HttpServletRequest request) throws IOException {
		 MultipartHttpServletRequest fileRequest = (MultipartHttpServletRequest)request;
         List<MultipartFile> files = fileRequest.getFiles("qqfile");
         
         String path = request.getSession().getServletContext().getRealPath("upload");
         System.out.println(path);
        List<String> urls = new ArrayList<String>();
         for (MultipartFile partFile : files)
         { 
 			String fileName = partFile.getOriginalFilename();
 			System.out.println(fileName);
 			 File targetFile = new File(path, fileName);  
 	        if(!targetFile.exists()){  
 	            targetFile.mkdirs();  
 	        }  
 	       partFile.transferTo(targetFile);  
 	       System.out.println(this.getFilePath(request,fileName));
 	      urls.add(this.getFilePath(fileRequest, fileName));
         }
		 /*List<String> urls = new ArrayList<String>();
		 urls.add("sfdffef");
		 urls.add("aaaaa");*/
         UploadResult result = new UploadResult(true);
         result.setData(urls);
         return result;
	}
	
	private String getFilePath(HttpServletRequest request,String fileName) {
		String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	    return basePath+"upload/"+fileName;
	}
	
	private class UploadResult {
		private boolean success = true;
		private Object data;
		public UploadResult(boolean isSuccess) {
			this.success = isSuccess;
		}
		public boolean isSuccess() {
			return success;
		}
		public void setSuccess(boolean success) {
			this.success = success;
		}
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
	}
}

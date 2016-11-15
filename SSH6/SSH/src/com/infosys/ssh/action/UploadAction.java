package com.infosys.ssh.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.struts2.ServletActionContext;

import com.infosys.ssh.domain.User;
import com.infosys.ssh.service.UserService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UploadAction extends ActionSupport {



	private File file;

	private String fileFileName;

	private String fileContectType;
	
	private UserService userService;

	
	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContectType() {
		return fileContectType;
	}

	public void setFileContectType(String fileContectType) {
		this.fileContectType = fileContectType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}


	public String execute() throws Exception {
		
		System.out.println("sdasd");
		System.out.println(file.getPath());
		
		InputStream is = new FileInputStream(file);

		String root = ServletActionContext.getRequest().getRealPath("/images/upload");

		File destFile = new File(root, this.getFileFileName());
		
		System.out.println(destFile.getPath());
		String imgPath = destFile.getPath().split("images", 2)[1];
		System.out.println(imgPath);
		
		User user = (User) ActionContext.getContext().getSession().get("currUser");
		int id = user.getId();
		if (userService.uploadImage(id,imgPath)) {
			user.setPicUrl(imgPath);
			ActionContext.getContext().getSession().put("currUser", user);
		} 
		
		
		OutputStream os = new FileOutputStream(destFile);

		byte[] buffer = new byte[400];

		int length = 0;

		while ((length = is.read(buffer)) > 0) {
			os.write(buffer);
		}

		is.close();

		os.close();

		return SUCCESS;
	}
}
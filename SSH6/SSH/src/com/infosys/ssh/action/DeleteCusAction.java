package com.infosys.ssh.action;

import com.infosys.ssh.dao.CustomerDao;
import com.opensymphony.xwork2.ActionSupport;

import freemarker.template.utility.Execute;

public class DeleteCusAction extends ActionSupport {

	private CustomerDao customerDao;
	public CustomerDao getCustomerDao() {
		return customerDao;
	}

	public void setCustomerDao(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	private String customerId;
	
	public String execute(){
		customerDao.deleteCustomer(customerId);
		return SUCCESS;
		
	}
}

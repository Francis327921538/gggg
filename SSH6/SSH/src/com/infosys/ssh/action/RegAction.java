package com.infosys.ssh.action;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.hibernate.ejb.criteria.expression.function.AggregationFunction.COUNT;

import com.infosys.ssh.dao.CustomerDao;
import com.infosys.ssh.domain.Customer;
import com.infosys.ssh.service.CustomerService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class RegAction extends ActionSupport{
	private CustomerService customerService;
	private int customerId; //获取注册表单customerId
	private String name;//获取注册表单name
	private String phone;//获取注册表单phone
	int COUNT = 10000;
	@Override
	public String execute() throws Exception{
		try{
			HttpSession session = ServletActionContext.getRequest().getSession();
			System.out.println(session+"------------------");
			//封装为对象
			Customer cus = new Customer();
			cus.setCustomerId(this.getCustomerId());
			System.out.println(this.getCustomerId());
			cus.setNo(COUNT ++);
			cus.setName(this.getName());
			cus.setPhone(this.getPhone());
			customerService.customerRegister(cus);//提交到service。调用customerRegister（）
		} catch(Exception ex){
			ex.printStackTrace();
			return INPUT;
		}
		return Action.SUCCESS;
	}
	
	
	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public int getCustomerId(){
		return customerId;
	}
	public String getName(){
		return name;
	}
	public String getPhone(){
		return phone;
	}
	public void setCustomerId(int customerId){
		this.customerId = customerId;
	}
	public void setName(String cusname){
		this.name = cusname;
	}
	public void setPhone(String cusphone){
		this.phone = cusphone;
	}
}

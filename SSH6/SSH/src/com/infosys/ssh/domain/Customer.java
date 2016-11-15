package com.infosys.ssh.domain;

public class Customer {
	private String name, phone;
	private int customerId;
	private int no;
	public Customer(){}
	public Customer(int customerId, String name, String phone, int no){
		this.customerId = customerId;
		this.name = name;
		this.phone = phone;
		this.no = no;
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
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", name=" + name + ", phone=" + phone + "]";
	}
	
}

package com.infosys.ssh.domain;


/**
 * 管理员实体
 * @author alan.chen
 *
 */
public class Admin {
	private int id;
	//private int adminId;//管理员id号 与员工号同步
	private String username;// 管理员名称
	private String password; // 密码
	private String description; // 管理员描述
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(int id,  String username, String password, String description) {
		super();
		this.id = id;
		//this.adminId = adminId;
		this.username = username;
		this.password = password;
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	/*public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}*/
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Admin [id=" + id  + ", username=" + username + ", password=" + password
				+ ", description=" + description + "]";
	}
	
	
	
}

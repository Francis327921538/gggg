package com.infosys.ssh.domain;

import java.util.HashSet;
import java.util.Set;

/**
 * 部门实体
 * @author alan.chen
 *
 */
public class Department {
	private int id;// 部门号
	private String depName;// 部门名称
	private String description; // 部门描述
	
	private Set<User> users = new HashSet<User>(); // 与User是一对多的关系
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(int id, String depName, String description) {
		super();
		this.id = id;
		this.depName = depName;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", depName=" + depName + ", description=" + description + ", users=" + users
				+ "]";
	}

	
	
	
	
}

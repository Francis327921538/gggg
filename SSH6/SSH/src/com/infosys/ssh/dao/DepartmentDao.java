package com.infosys.ssh.dao;

import java.util.List;

import com.infosys.ssh.domain.Department;

public interface DepartmentDao {
	public void add(Department department);
	
	public void deleteById(int id);
	
	public void delete(Department department);
	
	public void update(Department department);
	
	public Department findById(int id);
	
	public List<Department> find();
}

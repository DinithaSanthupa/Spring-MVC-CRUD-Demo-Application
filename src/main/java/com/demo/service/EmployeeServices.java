package com.demo.service;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeServices {
	
	public void addEmp(Employee emp);
	
	
	public List<Employee> getAllEmp();
	
	
	public Employee getById(Long id);
	
	
	public void updateEmp(Employee emp);
	
	
	public void deleteEmployee(Long id);

}

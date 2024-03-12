package com.demo.dao;

import java.util.List;

import com.demo.model.Employee;

public interface EmployeeDao {

	 public void addEmployee(Employee emp);

	 public List<Employee> getAllEmp();
	  
	 public Employee getEmpById(Long id);

	 public void updateEmp(Employee emp);
	 
	 public void deleteEmp(Long id);
}

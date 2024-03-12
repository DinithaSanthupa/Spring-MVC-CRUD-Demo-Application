package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.model.Employee;
import com.demo.serviceImpl.EmployeeServicesImpl;

@Controller
@RequestMapping
public class EmployeeController {

	@Autowired
	EmployeeServicesImpl employeeServices;
	
	//load add employee form
	@GetMapping("addEmployee")
	public String  addEmp()
	{
		return "AddEmployee";
		
	}
	
	//save employee form
	@PostMapping("/insertEmployee")
	public String insertEmployee(@ModelAttribute("insertEmployee") Employee emp)
	{
		
		employeeServices.addEmp(emp);
		return "redirect:/";
	}
	
	//load employee data
	@GetMapping("/")
	public String loadEmployee(Model m)
	{
		m.addAttribute("employee", employeeServices.getAllEmp());
		m.addAttribute("title", "Employee Report");
		
		return "EmployeeReport";
	}
	
	//load edit form 
	@GetMapping("/editEmployee/{id}")
	public String loadEditForm(@PathVariable(value="id") Long id, Model m)
	{
		Employee emp=employeeServices.getById(id);
		
		System.out.println(emp);
		m.addAttribute("employee", emp);
		m.addAttribute("title", "Edit Employee");
		
		return "EditEmployee";
		
	}
	
	@PostMapping("/editEmployee/updateEmployee")
	public String updateEmp(@ModelAttribute("updateEmployee") Employee emp)
	{
		employeeServices.updateEmp(emp);
		
		return "redirect:/";
		
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable Long id)
	{
		employeeServices.deleteEmployee(id);
		
		
		return "redirect:/";
	}
	
}

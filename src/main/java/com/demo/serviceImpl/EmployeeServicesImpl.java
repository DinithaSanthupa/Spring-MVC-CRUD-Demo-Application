package com.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;
import com.demo.service.EmployeeServices;

@Component
@Service
public class EmployeeServicesImpl implements EmployeeServices {
    
    @Autowired
    EmployeeDao employeeDao;
    
    //add employee
    @Override
    public void addEmp(Employee emp) {
        try {
            employeeDao.addEmployee(emp);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //get all employee
    @Override
    public List<Employee> getAllEmp() {
        try {
            return employeeDao.getAllEmp();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    //get emp by id
    @Override
    public Employee getById(Long id) {
        try {
            return employeeDao.getEmpById(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    // update employee
    @Override
    public void updateEmp(Employee emp) {
        try {
            employeeDao.updateEmp(emp);
        } catch (UnsupportedOperationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //delete employee 
    @Override
    public void deleteEmployee(Long id) {
        try {
            employeeDao.deleteEmp(id);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

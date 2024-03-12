package com.demo.daoImpl;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.demo.dao.EmployeeDao;
import com.demo.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao{
	
	private static final Logger logger = Logger.getLogger(EmployeeDaoImpl.class.getName());


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEmployee(Employee emp) {
    	logger.info("EmployeeDaoImpl addEmployee " + emp.getName() + " " + emp.getAddress());
        entityManager.persist(emp);
    }

    @Override
    public List<Employee> getAllEmp() {
    	logger.info("EmployeeDaoImpl get all employees");
        return entityManager.createQuery("SELECT e FROM Employee e", Employee.class).getResultList();
    }

    @Override
    public Employee getEmpById(Long id) {
    	logger.info("EmployeeDaoImpl find by id "  + id);
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void updateEmp(Employee emp) {
    	logger.info("EmployeeDaoImpl update "  + emp.getId());
        entityManager.merge(emp);
    }

    @Override
    public void deleteEmp(Long id) {
        Employee emp = entityManager.find(Employee.class, id);
        if (emp != null) {
            entityManager.remove(emp);
            logger.info("EmployeeDaoImpl deleteEmp "  + id);
        }else {
        	logger.warning("emplyee id does not exits");
        }
    }
}

package com.emps.managementsystem.service.impl;

import com.emps.managementsystem.exception.ResourceNotFoundException;
import com.emps.managementsystem.model.Employee;
import com.emps.managementsystem.repository.EmployeeRepository;
import com.emps.managementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//once method is created we have to implement it
@Service
public class EmployeeServiceImpl implements EmployeeService {

@Autowired
	private EmployeeRepository empRepo;
	@Override
	public Employee createEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return empRepo.save(employee);
	}
	@Override
	public List<Employee> getAllEmployees() {
		return empRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(long id) {

		return empRepo.findById(id).orElseThrow(()->  new ResourceNotFoundException("Employee", "Id", id)); //lambda expression

	}
	@Override
	public Employee updateEmployee(Employee employee, long id) {

		//checking to see if employee exist in database with given id
		Employee existingEmployee = empRepo.findById(id).orElseThrow( () ->  //defining employee in existingEmployee
				new ResourceNotFoundException("Employee", "Id", id));

		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setRole(employee.getRole());
		empRepo.save(existingEmployee);  //saving employee to db by calling the emp repo and pass existingEmployee object to it
		return existingEmployee;  //returning existing employee to controller layer
	}

	@Override
	public void deleteEmployee(long id) {

		empRepo.findById(id).orElseThrow( () ->
				new ResourceNotFoundException("Employee", "Id", id));
		empRepo.deleteById(id);


	}


}

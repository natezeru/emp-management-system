package com.emps.managementsystem.service;

import com.emps.managementsystem.model.Employee;

import java.util.List;
//controller layer depends on service layer
//once method is delcared in interface we have to implment it in the EmployeeServiceImpl class
public interface EmployeeService {
	Employee createEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	void deleteEmployee(long id); //making delete employee method
}

package com.emps.managementsystem.controller;

import com.emps.managementsystem.model.Employee;
import com.emps.managementsystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	@Autowired
	public EmployeeService empService;
	
	

	//building create employee RestAPI
	@PostMapping //Create employee
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){   //Response entity allows us provide complete response details like status, header, etc
		return new ResponseEntity<Employee>(empService.createEmployee(employee), HttpStatus.CREATED);
	}

	@GetMapping("/all")  //get all employees api
	public List<Employee> getAllEmployees(){
		return empService.getAllEmployees();
	}


	@GetMapping("/{id}")  //get employee by id  //creating pathvariable

	public ResponseEntity<Employee> getEmployeesById(@PathVariable ("id")long id){
		return new ResponseEntity<Employee>(empService.getEmployeeById(id), HttpStatus.OK);
	}

	@PutMapping("/{id}") //update employee
	public ResponseEntity<Employee> updateEmployee(@PathVariable ("id")long id , @RequestBody Employee employee){
	return new ResponseEntity<Employee>(empService.updateEmployee(employee, id), HttpStatus.OK);

	}

	@DeleteMapping("/{id}") //delete employee
	public ResponseEntity<String> deleteEmployee(@PathVariable ("id")long id){
		empService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee Deleted Sucessfully ", HttpStatus.OK);
	}
}

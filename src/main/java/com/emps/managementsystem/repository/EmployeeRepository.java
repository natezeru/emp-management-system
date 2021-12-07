package com.emps.managementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emps.managementsystem.model.Employee;
//the jpa repo allows for crud opps 
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}

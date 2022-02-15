package com.cg.demo.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.demo.dao.EmployeeNotFoundException;
import com.cg.demo.entities.Employee;
import com.cg.demo.service.EmployeeServiceI;

@RestController
@RequestMapping(value="employee")

//Connecting ... to Angular 
@CrossOrigin("http://localhost:4200")

public class EmployeeController {
	@Autowired
    private EmployeeServiceI service;
	
	
	@PostMapping(path="/create")
	public ResponseEntity<Boolean> CreateEmployee(@RequestBody Employee emp) {
		service.CreateEmployee(emp);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}
	
	@GetMapping(path="/getdetails/{empId}")
	public ResponseEntity<Employee> findEmployeeById(@PathVariable("empId") long empId) {
		Employee emp=service.findEmployeeById(empId);
		if (emp == null) {
            throw new EmployeeNotFoundException("employee not found for id=" + empId);
        }
		return new ResponseEntity<Employee>(emp,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(path="/getAll")
	public  ResponseEntity<List<Employee>> findAll(){
		List<Employee> list=service.findAllEmployees();
		
		return new ResponseEntity<List<Employee>>(list,new HttpHeaders(),HttpStatus.OK);
	}
	
	@PutMapping(path="/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee emp){
		emp=service.updateEmployee(emp);
		return new ResponseEntity<Employee>(emp,new HttpHeaders(),HttpStatus.OK);
	}
	
	@DeleteMapping(path="/delete/{empId}")
	public String deleteEmployee(@PathVariable("empId") Long empId) {
		service.deleteEmployee(empId);
		return "Deleted";
	}
}

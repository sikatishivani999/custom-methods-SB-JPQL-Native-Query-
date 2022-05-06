package com.method.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.method.entities.Employee;
import com.method.repository.EmployeeRepository;
import com.method.service.EmployeeService;

@RestController
public class MethodsController {
	
	@Autowired
	private EmployeeRepository EmployeeRepo;
	
	@Autowired
	private EmployeeService EmpService;
	
	
	//save Employee Data 
	@PostMapping("/saveEmployee")
	public Employee saveEmployeeDetails(@RequestBody Employee emp) {
		return EmpService.SaveEmployee(emp);
	}
	
	//get all employee
	@GetMapping("/AllEmployee")
	public List<Employee> getAllEmpDetails(){
		return EmpService.listOfEmployee();
	}
	
	//get details by id
	@GetMapping("/employee/{id}")
	public Optional<Employee> getEmployeeDetails(@PathVariable int id) {
		return EmpService.EmployeeData(id);
	}
	
	//edit employee details by id
	@PutMapping("/edit/{id}")
	public Employee editEmployeeDetails(@RequestBody Employee emp) {
		return EmpService.SaveEmployee(emp);
	}
	
	@DeleteMapping("/delete/{id}")
	public void DeteleEmployee(@PathVariable int id) {
		EmpService.DeleteRecord(id);
	}
	
	//find by designation
	@GetMapping("/fetchDesg/{designation}")
	public List<Employee> getByDesignation(@PathVariable String designation){
		return EmpService.fetchByDesignation(designation);
	}
	//find by designation and role
	@GetMapping("/fetchData/{designation}/{role}")
	public List<Employee> getByDesignationAndRole(@PathVariable String designation,@PathVariable String role) {
		return EmpService.fetchByDesignationAndRole(designation, role);
	}
	
	//find by contact
	@GetMapping("/fetchDetail/{contact}")
	public Employee getByContact(@PathVariable long contact){
		return EmpService.fetchByContact(contact);
	}
	
	//find by full name ends with 
	@GetMapping("/fetchName/{fullName}")
	public List<Employee> getByfullName(@PathVariable String fullName){
		return EmpService.fetchByfullNameEndsWith(fullName);
	}
	
	//find by full name ends with 
	@GetMapping("/fetchNameStarts/{fullName}")
	public List<Employee> getByfullNameStarts(@PathVariable String fullName){
		return EmpService.fetchByfullNameStartsWith(fullName);
	}
	
	@GetMapping("/fetchDesgOrderByName/{designation}")
	public List<Employee> getByDesignationOrderByFullname(@PathVariable String designation){
		return EmpService.fetchByDesginationOrderByFullname(designation);
	}
	
	@GetMapping("/fetchRole/{role}")
	public List<Employee> findByRole(@PathVariable String role){
		return EmpService.fetchByRole(role);
	}
	
	@GetMapping("/fetchfullName/{fullName}")
	public List<Employee> findByFullName(@PathVariable String fullName){
		return EmpService.fetchByFullName(fullName);
	}
	
	@DeleteMapping("/dropByEmail/{email}")
	public Integer DeleteEmployeeByEmail(@PathVariable String email){
		return EmpService.dropByEmail(email);
	}
	
	@PutMapping("/updateContact/{contact}/{email}")
	public Integer changeContact(@PathVariable long contact,@PathVariable String email) {
		return EmpService.updateContact(contact, email);
	}
	
	@GetMapping("/allRecords")
	public List<Employee> displayAllRecords(){
		return EmpService.fetchAllRecords();
	}
} 

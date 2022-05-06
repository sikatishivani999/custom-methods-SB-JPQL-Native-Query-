package com.method.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.method.entities.Employee;
import com.method.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeRepository EmployeeRepo;
	
	//method to save data
	public Employee SaveEmployee(Employee emp) {
		return EmployeeRepo.save(emp);
	}
	
	//method to get all data at once 
	public List<Employee> listOfEmployee(){
		return EmployeeRepo.findAll();
	}
	
	//method to delete emp by id 
	public void DeleteRecord(int id) {
		EmployeeRepo.deleteById(id);
	}
	
	//method to find by id
	public Optional<Employee> EmployeeData(int id) {
		return EmployeeRepo.findById(id);
	}
	
	//method to find by designation
	public List<Employee> fetchByDesignation(String desg) {
		return EmployeeRepo.findByDesignation(desg);
	}
	
	//method to find by designation and role
	public List<Employee> fetchByDesignationAndRole(String desg, String role){
		return EmployeeRepo.findByDesignationAndRole(desg, role);
	}
	
	//method to fetch by contact 
	public Employee fetchByContact(long Contact){
		return EmployeeRepo.findByContact(Contact);
	}
	
	//method to fetch full name endswith
	public List<Employee> fetchByfullNameEndsWith(String fullName){
		return EmployeeRepo.findByFullNameEndingWith(fullName);
	}
	
	//method to fetch full name starts with 
	public List<Employee> fetchByfullNameStartsWith(String fullName){
		return EmployeeRepo.findByFullNameStartingWith(fullName);
	}
	
	//method to fetch designation order by in descending by full name
	public List<Employee> fetchByDesginationOrderByFullname(String designation){
		return EmployeeRepo.findByDesignationOrderByFullNameDesc(designation);
	}
	
	//method to fetch all data by role
	public List<Employee> fetchByRole(String role){
		return EmployeeRepo.getEmployeeByRole(role);
	}
	
	//method to fetch all data by full name
	public List<Employee> fetchByFullName(String fullName){
		return EmployeeRepo.getEmployeeByFullName(fullName);
	}
	
	//method to delete record by email
	public Integer dropByEmail(String email){
		return EmployeeRepo.deleteByEmail(email);
	}
	
	//method  to update contact by email of employee
	public Integer updateContact(long contact,String email){
		return EmployeeRepo.updateContactByEmail(contact, email);
	}
	
	//method to fetch all employee using native query method
	public List<Employee> fetchAllRecords(){
		return EmployeeRepo.getAllEmployee();
	}
}












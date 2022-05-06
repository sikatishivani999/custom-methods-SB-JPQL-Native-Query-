package com.method.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.method.entities.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	List<Employee> findByDesignation(String designation);
	
	List<Employee> findByDesignationAndRole(String desigantion, String role);
	
	Employee findByContact(long Contact);
	
	Employee findByEmail(String Email);
	
	List<Employee> findByFullNameEndingWith(String fullName);
	
	List<Employee> findByFullNameStartingWith(String fullName);
	
	List<Employee> findByDesignationOrderByFullNameDesc(String designation);
	
	//select query in JPQL
	@Query("FROM Employee WHERE role = :role")
	List<Employee> getEmployeeByRole(String role);
	
	@Query("FROM Employee WHERE fullName = ?1")
	List<Employee> getEmployeeByFullName(String fullName); //Here ?1 is the index of the method argument. Index starts from 1.
	
	//delete query in JPQL
	@Transactional
	@Modifying //@Modifying annotation is used whenever we writing JPQL query for modifying the records (create, update, delete)
	@Query("DELETE FROM Employee WHERE email = :email") //JPQL query always returns either void or integer whenever we are writing a query for modifying
	Integer deleteByEmail(String email);
	
	//update query in JPQL 
	@Transactional
	@Modifying
	@Query("UPDATE Employee SET contact = :contact WHERE email = :email")
	Integer updateContactByEmail(long contact, String email);
	
	
	//select query in native 
	@Query(value="SELECT * FROM Employee_Details", nativeQuery = true)
	List<Employee> getAllEmployee();
	
}

package com.method.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee_Details")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String fullName;
	
	@Column(unique = true)
	private String email;
	
	@Column
	private String password;
	
	@Column
	private long contact;
	
	@Column
	private Date dob;
	
	@Column
	private String designation;
	
	@Column
	private String role;
	
	
	

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String fullName, String email, String password, long contact, Date dob, String designation,
			String role) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.password = password;
		this.contact = contact;
		this.dob = dob;
		this.designation = designation;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", FullName=" + fullName + ", Email=" + email + ", Password=" + password
				+ ", Contact=" + contact + ", dob=" + dob + ", designation=" + designation + ", role=" + role + "]";
	}
	
	
	
	

}

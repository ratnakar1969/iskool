package com.edu.iskool.model;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "iskool_student")
public class Student implements Serializable {
	
	
	@Column(name="student_name")
	private String studentName;
	
	@Id
	@Column(name="student_id")
	private Long studentID;
	
	@Column(name="student_doj")
	private Date dateOfJoining;
	
	@Column(name="student_dob")
	private Date dateOfBirth;
	
	@Column(name="student_age")
	private Integer age;
	
	@Column(name="student_gender")
	private String gender;



	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public Long getStudentID() {
		return studentID;
	}

	public void setStudentID(Long studentID) {
		this.studentID = studentID;
	}

	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentID=" + studentID + ", dateOfJoining=" + dateOfJoining
				+ ", dateOfBirth=" + dateOfBirth + ", age=" + age + ", gender=" + gender + "]";
	}

	

}

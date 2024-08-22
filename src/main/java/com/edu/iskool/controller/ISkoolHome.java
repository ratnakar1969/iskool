package com.edu.iskool.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.iskool.dao.StudentRepository;
import com.edu.iskool.model.Student;

@RestController
@RequestMapping("/iskool")
public class ISkoolHome {
	

@Autowired
private StudentRepository studentRep;

	
@RequestMapping(value = "/getAllStudents")
public ResponseEntity<List<Student>> getAllStudents() {
    List<Student> stdList=studentRep.findAll();
    System.out.println("Got All Students"+stdList) ;
    return new ResponseEntity<List<Student>>(stdList, new HttpHeaders(), HttpStatus.OK);
}

@RequestMapping(value = "/getStudent/"
		+ "{id}")
public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
    Student student=studentRep.findById(id).get();
    System.out.println("Got Student"+student) ;
    return new ResponseEntity<Student>(student, new HttpHeaders(), HttpStatus.OK);
}

@RequestMapping(value = "/addStudent", method = RequestMethod.POST)
public ResponseEntity<Object> createProduct(@RequestBody Student student) {
    studentRep.save(student);
   return new ResponseEntity<>("Student is added successfully", HttpStatus.CREATED);
}
	

}

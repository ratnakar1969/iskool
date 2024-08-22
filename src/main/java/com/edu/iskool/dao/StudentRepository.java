package com.edu.iskool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.iskool.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

}

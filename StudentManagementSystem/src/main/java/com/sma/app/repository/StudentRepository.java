package com.sma.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sma.app.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	
	public List<Student>findAllByBatchNumber(String batchNumber);
	
	
	
}

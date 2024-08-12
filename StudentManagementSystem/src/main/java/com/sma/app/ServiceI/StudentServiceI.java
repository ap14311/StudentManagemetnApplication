package com.sma.app.ServiceI;

import java.util.List;

import com.sma.app.model.Student;

public interface StudentServiceI {
	
	public String savestudentdetailsStudent(Student st);
	
	public List<Student> getAllStudent();
	public List<Student> searchStudentByBatchNumber(String batchNumber);
	public Student getSingleStudent(int id);
	public void updateStudentFees(int StudentId, float ammount);

}

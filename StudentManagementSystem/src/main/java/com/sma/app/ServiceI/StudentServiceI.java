package com.sma.app.ServiceI;

import java.util.List;

import com.sma.app.model.Student;

public interface StudentServiceI  {

	public void saveStudentDetails(Student s);
	public List<Student> getAllStudents();
	
	public abstract void   deleteStudent(int i);
	public List<Student> searchStudentByBatch(String batchNumber);
	
	
//	 public abstract void saveStudentDetails(Student student);

	//    public abstract List getAllStudents();

	  //  public abstract void deleteStudent(int i);

	    public abstract List seachStudentByBatch(String s);

	    public abstract Student getSingleStudent(int id);

	    public abstract void updateStudentFees(int studentId, double ammount);
	
}

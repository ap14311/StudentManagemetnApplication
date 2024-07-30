package com.sma.app.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sma.app.ServiceI.StudentServiceI;
import com.sma.app.model.Student;
import com.sma.app.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentServiceI {
	
	
	@Autowired
	 private StudentRepository sr;

	
	@Override
	public void  saveStudentDetails(Student s)
	{
		sr.save(s);
		
	}


	@Override
	public List<Student> getAllStudents() {
		
		return sr.findAll();
	}


	@Override
	public void deleteStudent(int studentId) {
		 sr.deleteById(Integer.valueOf(studentId));
		
	}


	@Override
	public List<Student> searchStudentByBatch(String batchNumber) {
		List<Student> batchstudents=sr.findAllByBatchNumber(batchNumber);
		return batchstudents;
	}


	@Override
	public List seachStudentByBatch(String studentBatchNumber) {
		// TODO Auto-generated method stub
		return sr.findAllByBatchNumber(studentBatchNumber);
		
	}


	@Override
	public Student getSingleStudent(int id) {
		 Optional opStudent = sr.findById(Integer.valueOf(id));
	        return (Student)opStudent.get();
		
	}


	@Override
	public void updateStudentFees(int studentId, double ammount) {
		// TODO Auto-generated method stub
		Optional opStudent = sr.findById(Integer.valueOf(studentId));
        Student st = (Student)opStudent.get();
        st.setFeesPaid(st.getFeesPaid() + ammount);
        sr.save(st);
	}


	


}

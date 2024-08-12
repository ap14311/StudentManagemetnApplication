package com.sma.app.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sma.app.ServiceI.StudentServiceI;
import com.sma.app.model.Student;
import com.sma.app.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentServiceI{

	@Autowired
	private StudentRepository sr;
	
	@Override
	public String savestudentdetailsStudent(Student st) {
		
	  sr.save(st);
	return "enroll student";
	}

	@Override
	public List<Student> getAllStudent() {
		
		return sr.findAll();
	}

	@Override
	public List<Student> searchStudentByBatchNumber(String batchNumber) {
		List<Student> batchStudent=sr.findAllByBatchNumber(batchNumber);
		return batchStudent;
	}

	@Override
	public Student getSingleStudent(int id) {
		Optional<Student>opStudent=sr.findById(id);
		
		return opStudent.get();
	}

	@Override
	public void updateStudentFees(int StudentId, float ammount) {
		Optional<Student>students=sr.findById(StudentId);
		Student st=students.get();
		st.setFeesPaid(st.getFeesPaid()+ammount);
		sr.save(st);
		
	}

	

}

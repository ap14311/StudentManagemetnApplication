package com.sma.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sma.app.ServiceI.StudentServiceI;
import com.sma.app.model.Student;

@Controller
public class AdminController {
	
	@Autowired
	StudentServiceI ssi;
	
	@RequestMapping("/")
	public String preLogin()
	{
		return "login";
	}
	@RequestMapping("/login")
	public String onLogin(@RequestParam String username, @RequestParam String password, Model m)
	{
		
		if(username.equals("admin")&& password.equals("Amar@14311"))
		{
			List<Student> students=ssi.getAllStudents();
			
			m.addAttribute("data", students);
			return "adminscreen";
		}
		else
		{
			m.addAttribute("login_fail","enter valid details.");
			return "login";
		}
	}
		@RequestMapping("/enroll_student")
		public String saveStudentDetails(@ModelAttribute Student s, Model m)
		{
			ssi.saveStudentDetails(s);
			List<Student> students=ssi.getAllStudents();
			m.addAttribute("data", students);
			return "adminscreen";
		}

		
		
		@RequestMapping("/delete")
		 public String deleteStudent(int studentId, Model m)
		    {
		        ssi.deleteStudent(studentId);
		        List list = ssi.getAllStudents();
		        m.addAttribute("data", list);
		        return "adminscreen";
		    }
		@RequestMapping("/search")
		public String getBatchStudent(@ModelAttribute String batchNumber, Model m)
		{
			List<Student>result=ssi.searchStudentByBatch(batchNumber);
			if(result.size()>0)
			{
				m.addAttribute("data", result);
			}
			else {
			List<Student> result1=ssi.getAllStudents();
			m.addAttribute("data",  result1);
			m.addAttribute("message", "NO RECORD FOUND");
			}
			return "adminscreen";
		}
		
		 public String onFees(int id, Model m)
		    {
		        Student st = ssi.getSingleStudent(id);
		        m.addAttribute("st", st);
		        return "fees";
		    }

		    public String payFees(int studentId, double ammount, Model m)
		    {
		        ssi.updateStudentFees(studentId, ammount);
		        List list = ssi.getAllStudents();
		        m.addAttribute("data", list);
		        return "fees";
		    }

		
	
		
	
}

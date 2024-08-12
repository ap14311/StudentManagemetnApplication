package com.sma.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sma.app.ServiceI.StudentServiceI;
import com.sma.app.model.Student;

@Controller
public class AdminController {
	
	@Autowired 
	private StudentServiceI ssi;

	@RequestMapping("/")
	public String Prelogin()
	{
		return "login";
	}
	
	@RequestMapping("/login")
	public String onlogin( @RequestParam String username, @RequestParam String password, Model m)
	{
		if(username.equals("admin")&& password.equals("Amar@14311"))
		{
			List<Student>students=ssi.getAllStudent();
			m.addAttribute("data", students);
			return "adminscreen";
		}
		else
		{
		
			m.addAttribute("login_fail", "enter valid login details");
			return "login";
			
		}
		
	}
	@RequestMapping("/enroll_student")
	public String saveStudent(@ModelAttribute Student s, Model m)
	{
		ssi.savestudentdetailsStudent(s);
		List<Student>students=ssi.getAllStudent();
		m.addAttribute("data", students);
		return "adminscreen";
	}
	@RequestMapping("/search")
	public String getBatchStudent(@RequestParam String batchNumber, Model m)
	{
		List<Student> result=ssi.getAllStudent();
		if(result.size()>0)
		{
			m.addAttribute("data", result);
		}
		else
		{
			List<Student>students=ssi.getAllStudent();
			m.addAttribute("data",students);
			m.addAttribute("message","record not found ");
		}
		return "adminscreen";
		
	}
	@RequestMapping("/Fees")
	public String onFees(@RequestParam int id, Model m)
	{
		Student st=ssi.getSingleStudent(id);
		return "Fees";
	}
	@RequestMapping("/payfees")
	public String payFees(@RequestParam int StudentId, @RequestParam float ammount, Model m)
	{
		ssi.updateStudentFees(StudentId,ammount);
		List<Student>students=ssi.getAllStudent();
		m.addAttribute("data", students);
		return "adminscreen";
		
	}
	
}

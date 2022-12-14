package com.example.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService ss;
	
	@RequestMapping("home")
	public String getHome() {
		return "home.jsp";
	}
	
	@RequestMapping("addStudent")
	public String addStudent(HttpServletRequest req, HttpServletResponse res) {
		int rollno = Integer.parseInt(req.getParameter("rollno"));
		String name = req.getParameter("name");
		String dept = req.getParameter("dept");
		float grade = Float.parseFloat(req.getParameter("grade"));
		Student s = new Student(rollno,name,dept,grade);
		
		return ss.addStudent(s);
	}
}

package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.model.Student;

@Service
public class StudentService {
	@Autowired
	private StudentDao sdao;
	
	public String addStudent(Student s) {
		sdao.save(s);
		return "Student added";
	}
	
	public String getStudent(int rollno) {
		Student s = sdao.findById(rollno).orElse(null);
		if(s!=null)
			return s.toString();
		else {
			return "Student Unavailable";
		}
	}
	
	public List<Student> getAllStudents(){
		return sdao.findAll();
	}
	
	public String updateStudent(Student s) {
		sdao.deleteById(s.getRollno());
		sdao.save(s);
		return "Student Updated";
	}
	
	public String deleteStudent(int rollno) {
		sdao.deleteById(rollno);
		return "Student Deleted";
	}
}

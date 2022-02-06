package com.seleniumexpress.sm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.service.StudentService;

@Controller
public class StudentController {
	@Autowired
	StudentService studentService;

	@GetMapping("/showStudent")
	public String showStudentLists(Model model) {
		List<Student> studentList = studentService.loadStudents();

		model.addAttribute("students", studentList);
		return "student-list";
	}

	@GetMapping("/showAddStudentPage")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);

		return "add-student";
	}

	@GetMapping("/updateStudent")
	public String updateStudent(@RequestParam("userId") int Id, Model model) {
		Student theStudent = studentService.getStudent(Id);
		model.addAttribute("student", theStudent);
		return "add-student";
	}

	@GetMapping("/deleteStudent")
	public String deleteStudent(@RequestParam("userId") int Id)
	{
		studentService.deleteStudent(Id);
		return "redirect:/showStudent";
		
	}
	
	
	@PostMapping("/studentSave")
	public String studentSave(Student student) {
		System.out.println(student.toString());
		studentService.studentSave(student);

		return "redirect:/showStudent";
	}

}

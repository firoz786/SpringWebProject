package com.seleniumexpress.sm.service;

import java.util.List;

import com.seleniumexpress.sm.api.Student;

public interface StudentService {

	List<Student> loadStudents();
	void studentSave(Student student);
	Student getStudent(int id);
	void deleteStudent(int id);
}

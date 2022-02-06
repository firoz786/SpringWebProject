package com.seleniumexpress.sm.DAO;

import java.util.List;
import com.seleniumexpress.sm.api.Student;

public interface StudentDAO {

	List<Student> loadStudents();
	
	void studentSave(Student student);
	
	Student getStudent(int id);

	void deleteStudent(int id);
}

package com.seleniumexpress.sm.DAO;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.seleniumexpress.sm.api.Student;
import com.seleniumexpress.sm.rowmapper.StudentRowMapper;

@Repository
public class StudentDAOImpl implements StudentDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Override
	public List<Student> loadStudents() {
			
		String sql="select * from students";
		
		List<Student> theListOfStudents = jdbcTemplate.query(sql,new StudentRowMapper());
		
		return theListOfStudents;
	}
	
	@Override
	public void studentSave(Student student) {
	
		if(student.getId()==0)
		{	
			Object[] sqlParameter= {student.getName(),student.getMobile(),student.getCountry()};
			String sql = "insert into students(name,mobile,country) values (?,?,?)";
			jdbcTemplate.update(sql, sqlParameter);
			System.out.println("one record inserted!!!");	
		}
		else 
		{
			String sql= "update students set name = ?,mobile =?,country=? where id =?";
			jdbcTemplate.update(sql, student.getName(),student.getMobile(),student.getCountry(),student.getId());
			System.out.println("1 Record updated!!!");
		}
	}

	@Override
	public Student getStudent(int id) {
		String sql = "select * from students where id = ?";
		Student student = jdbcTemplate.queryForObject(sql, new StudentRowMapper(),id);
		return student;
	}

	@Override
	public void deleteStudent(int id) {
		String sql ="delete from students where id = ?";
		jdbcTemplate.update(sql, id);
		System.out.println("1 record deleted.!!!");
	}

}

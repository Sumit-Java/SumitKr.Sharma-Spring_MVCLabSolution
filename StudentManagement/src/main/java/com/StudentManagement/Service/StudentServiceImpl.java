package com.StudentManagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.StudentManagement.DAO.StudentDAO;
import com.StudentManagement.Entity.Student;


@Repository
@EnableTransactionManagement
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	@Transactional
	public List<Student> getAllStudentsRecord() {
		return studentDAO.getAllStudentsRecord();
	}

	@Override
	@Transactional
	public Student getStudentById(int Id) {
		return studentDAO.getStudentById(Id);
		
	}

	@Override
	@Transactional
	public void saveStudent(Student student) {
		studentDAO.saveStudent(student);

	}

	@Override
	@Transactional
	public void deleteStudentById(int Id) {
		studentDAO.deleteStudentById(Id);

	}

}

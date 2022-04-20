package com.StudentManagement.DAO;

import java.util.List;

import com.StudentManagement.Entity.Student;

public interface StudentDAO {

	public List<Student> getAllStudentsRecord();

	public Student getStudentById(int Id);

	public void saveStudent(Student student);

	public void deleteStudentById(int Id);

}

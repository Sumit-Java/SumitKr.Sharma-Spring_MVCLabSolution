package com.StudentManagement.Service;

import java.util.List;

import com.StudentManagement.Entity.Student;

public interface StudentService {

	public List<Student> getAllStudentsRecord();

	public Student getStudentById(int Id);

	public void saveStudent(Student student);

	public void deleteStudentById(int Id);
}

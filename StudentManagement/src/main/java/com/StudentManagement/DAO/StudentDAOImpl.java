package com.StudentManagement.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.StudentManagement.Entity.Student;

@Repository
@Transactional
@EnableTransactionManagement
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Student> getAllStudentsRecord() {
		//Getting a Hibernate Session.
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Student> query = currentSession.createQuery("from Student order by id", Student.class);
		List<Student> allStudents = query.getResultList();
		return allStudents;
	}

	@Override
	public Student getStudentById(int Id) {
		Session currentSession = sessionFactory.getCurrentSession();
		Student student = currentSession.get(Student.class, Id);
		return student;
	}
	
	@Override
	@Transactional
	public void saveStudent(Student student) {

		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(student);
	}

	@Override
	@Transactional
	public void deleteStudentById(int Id) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Student student = currentSession.get(Student.class,Id);
		currentSession.delete(student);
		
		/*
		 * Query createQuery =
		 * currentSession.createQuery("Delete from Student where id=:studentId");
		 * createQuery.setParameter("studentId", Id); createQuery.executeUpdate();
		 */
		
	}

}

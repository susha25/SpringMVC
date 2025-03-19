package com.spring.orm.dao;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.entity.Student;

public class StudentDao {
	
	private HibernateTemplate hbt; 
	
	public HibernateTemplate getHbt() {
		return hbt;
	}

	public void setHbt(HibernateTemplate hbt) {
		this.hbt = hbt;
	}
	
	

	@Transactional
	public int insert(Student std)
	{
		Integer i = (Integer)hbt.save(std);
		return i;
		
	}
	
	@Transactional
	public void update(Student std)
	{
		this.hbt.update(std);
	}
	
	@Transactional
	public List<Student> getAllStudent()
	{
		List<Student> std = this.hbt.loadAll(Student.class);
		return std;
	}
	
	@Transactional
	public Student getStudent(int studentId)
	{
		Student std = this.hbt.get(Student.class, studentId);
		return std;
	}
	
	@Transactional
	public void deleteStudent(int studentId)
	{
		Student std = this.hbt.get(Student.class, studentId);
		this.hbt.delete(std);
	}

}

package com.jbk.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jbk.dao.StudentDao;
import com.jbk.dao.StudentDao_impl;
import com.jbk.entity.Student;
import com.jbk.model.Branch;

@Service
public class StudentService_impl implements StudentService {

	@Autowired
	private StudentDao dao;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Student saveStudent(Student student) {
		String studentId = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		student.setStudentId(studentId);
		Student std = dao.saveStudent(student);
		return std;
	}

	@Override
	public Student getStudentById(String studentId) {
		Student student = dao.getStudentById(studentId);
		return student;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list = dao.getAllStudent();
		return list;
	}

	@Override
	public boolean deleteStudentById(String StudentId) {

		boolean b = dao.deleteStudentById(StudentId);
		return b;
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Branch getBranchById(String branchId) {
		//call another microservice
	Branch branch=	restTemplate.getForObject("http://localhost:8081/branch/getBranch/"+branchId, Branch.class);
		return branch;
	}

}

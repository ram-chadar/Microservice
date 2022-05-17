package com.jbk.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.entity.Student;
import com.jbk.model.Branch;
import com.jbk.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private StudentService service;

	@PostMapping(value = "/saveStudent")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student) {

		Student std = service.saveStudent(student);
		if (std != null) {
			return new ResponseEntity<>(std, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/getStudent/{studentId}")
	public ResponseEntity<Student> getStudent(@PathVariable String studentId) {

		Student student = service.getStudentById(studentId);
		if (student != null) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping(value = "/getAllStudent")
	public ResponseEntity<List<Student>> getAllStudent() {

		List<Student> list = service.getAllStudent();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);

		} else {
			return new ResponseEntity<>(list, HttpStatus.OK);
		}

	}

	@DeleteMapping(value = "/deleteStudentById/{studentId}")
	public ResponseEntity<String> deleteStudentById(@PathVariable String studentId) {
		boolean b = service.deleteStudentById(studentId);
		if (b == true) {
			return new ResponseEntity<>("deleted " + studentId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Something Went Wrong to delete " + studentId,
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(value = "/getBranchById/{branchId}")
	public ResponseEntity<Branch> getBranch(@PathVariable String branchId) {
		Branch branch = service.getBranchById(branchId);
		if (branch != null) {
			return new ResponseEntity<>(branch, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

}

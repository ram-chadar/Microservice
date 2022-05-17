package com.jbk.branch.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jbk.branch.entity.Branch;
import com.jbk.branch.service.BranchService;


@RestController
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	private BranchService service;

	@PostMapping(value = "/saveBranch")
	public ResponseEntity<Branch> saveStudent(@RequestBody Branch branch) {

		Branch brnch = service.saveBranch(branch);
		if (brnch != null) {
			return new ResponseEntity<>(brnch, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping(value = "/getBranch/{branchId}")
	public ResponseEntity<Branch> getStudent(@PathVariable String branchId) {

		Branch branch = service.getBranchById(branchId);
		if (branch != null) {
			return new ResponseEntity<>(branch, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}

}

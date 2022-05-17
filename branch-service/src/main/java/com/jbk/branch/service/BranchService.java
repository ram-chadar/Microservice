package com.jbk.branch.service;

import com.jbk.branch.entity.Branch;

public interface BranchService {

	public Branch saveBranch(Branch branch);

	public Branch getBranchById(String branchId);
	


}

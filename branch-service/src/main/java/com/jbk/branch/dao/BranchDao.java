package com.jbk.branch.dao;

import com.jbk.branch.entity.Branch;

public interface BranchDao {

	public Branch saveBranch(Branch branch);

	public Branch getBranchById(String branchId);
}

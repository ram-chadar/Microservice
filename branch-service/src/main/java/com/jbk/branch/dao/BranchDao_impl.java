package com.jbk.branch.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jbk.branch.entity.Branch;

@Repository
public class BranchDao_impl implements BranchDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public Branch saveBranch(Branch branch) {
		Session session = sf.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			session.save(branch);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

		return branch;
	}

	@Override
	public Branch getBranchById(String branchId) {
		Session session = sf.openSession();
		Branch branch = null;
		try {
			branch = session.get(Branch.class, branchId);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return branch;
	}

}

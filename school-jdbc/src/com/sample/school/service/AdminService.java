package com.sample.school.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.dao.DeptDAO;
import com.sample.school.vo.Dept;

public class AdminService {

	private DeptDAO deptDao = new DeptDAO();
	
	public boolean addNewDept(Dept dept) throws SQLException {
		deptDao.addDept(dept);
		return false;
	}
	
	public boolean updateDept(Dept dept) throws SQLException {
		deptDao.updateDept(dept);
		return false;
	}
	
	public boolean removeDept(Dept dept) throws SQLException {
		deptDao.removeDept(dept);
		return false;
	}
	
	public Dept getDeptByNo(int deptNo) throws SQLException {
		Dept dept = null;
		
		return dept;
	}
	
	public List<Dept> getAllDepts() throws SQLException {
		return deptDao.getAllDepts();
	}
	
}

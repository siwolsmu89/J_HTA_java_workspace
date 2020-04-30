package com.sample.school.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sample.school.dao.DeptDAO;
import com.sample.school.vo.Dept;

public class AdminService {

	private DeptDAO deptDao = new DeptDAO();
	
	/**
	 * Adds the informations of a new Department to the table depts.
	 * 
	 * @param dept contains the informations of a department.
	 * @return Returns true when succeeded. 
	 * 		   If there's same deptNo or deptName, returns false.
	 * @throws SQLException
	 */
	public boolean addNewDept(Dept dept) throws SQLException {
		Dept savedDept = deptDao.getDeptByNo(dept.getNo());
		if(savedDept != null) {
			return false;
		}
		savedDept = deptDao.getDeptByName(dept.getName());
		if(savedDept != null) {
			return false;
		}
		
		deptDao.addDept(dept);
		return true;
	}
	
	/**
	 * Updates the informations of a Department in the table depts.
	 * @param dept contains the informations of a department.
	 * @return Returns true when succeeded.
	 * 		   If there's no matching department in the table, return false.
	 * @throws SQLException
	 */
	public boolean updateDept(Dept dept) throws SQLException {
		Dept savedDept = deptDao.getDeptByNo(dept.getNo());
		if(savedDept == null) {
			return false;
		}
		
		deptDao.updateDept(dept);
		return true;
	}
	
	/**
	 * Removes the informations of a Department in the table depts.
	 * @param dept contains the informations of a department.
	 * @return Returns true when succeeded.
	 * 		   If there's no matching department in the table, return false.
	 * @throws SQLException
	 */
	public boolean removeDept(Dept dept) throws SQLException {
		Dept savedDept = deptDao.getDeptByNo(dept.getNo());
		if(savedDept == null) {
			return false;
		}
		
		if(!savedDept.getName().equals(dept.getName())) {
			return false;
		}
		
		deptDao.removeDept(dept);
		return true;
	}
	
	/**
	 * Gets the informations of a department from the table depts.
	 * @param Keyword is a key used to find a matching department from table.
	 * @return Dept dept contains the informations of a department.
	 * @throws SQLException
	 */
	public Dept getDeptByKeyword(String keyword) throws SQLException {
		Dept dept = deptDao.getDeptByName(keyword);
		
		if (dept == null) {
			try {
				int parsedKeyword = Integer.parseInt(keyword);
				dept = deptDao.getDeptByNo(parsedKeyword);
			} catch (NumberFormatException e) {
			}
		}
		
		return dept;
	}
	
	/**
	 * Gets the informations of all departments from the table depts. 
	 * @return List<Dept> allDepts is an ArrayList<Dept> contains all Dept Objects.
	 * @throws SQLException
	 */
	public List<Dept> getAllDepts() throws SQLException {
		return deptDao.getAllDepts();
	}
	
}

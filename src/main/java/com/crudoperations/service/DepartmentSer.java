package com.crudoperations.service;

import java.util.List;

import com.crudoperations.dao.DepartmentDAO;
import com.crudoperations.dto.Department;

public class DepartmentSer {
	public static String createDepartment(Department dept) { 
	    return new DepartmentDAO().createDepartment(dept);
	  }
	public static String updateDepartment(String DeptName, int DeptID) { 
	    return new DepartmentDAO().updateDepartment(DeptName, DeptID);
	  }
	public static String deleteDepartment(int deptid) { 
	    return new DepartmentDAO().deleteDepartment(deptid);
	  }
	public static List<Department> getAllDepartments() {
		return new DepartmentDAO().getAllDepartments();
	}
}

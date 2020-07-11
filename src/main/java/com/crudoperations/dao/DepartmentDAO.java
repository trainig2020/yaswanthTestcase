package com.crudoperations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudoperations.dto.Department;

public class DepartmentDAO {
	Connection con;
	PreparedStatement pst;
	public String createDepartment(Department dept) {
		con = DaoConnection.getConnection();
		String cmd= "insert into Department(DeptID,DeptName) values(?,?)";
		String result = "";
		try {
			pst = con.prepareStatement(cmd);
			pst.setInt(1, dept.getDeptID());
			pst.setString(2, dept.getDeptName());
			pst.executeUpdate();
			result = "Department Details Added Successfully";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public String updateDepartment(String DeptName, int DeptID) {
		 con=DaoConnection.getConnection();
		 String cmd="Update Department set DeptName=? where DeptID=?";
		 String result= "";
		 try {
			pst =con.prepareStatement(cmd);
			pst.setString(1, DeptName);
			pst.setInt(2, DeptID);
			pst.executeUpdate();
			result = "Department Updated successfully";
			
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return result;
	}

	public String deleteDepartment(int deptid) {
		con = DaoConnection.getConnection();
		String cmd = "delete from Department where DeptID=?";
		String result = "";
		try {
			pst = con.prepareStatement(cmd);
			pst.setInt(1, deptid);
			pst.executeUpdate();
			result = "Department details deleted successfully";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Department> getAllDepartments() {
		con = DaoConnection.getConnection();
		String cmd = "select * from Department";
		Department d = null;
		List<Department> lst =new ArrayList<Department>();
		try {
			pst = con.prepareStatement(cmd);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
			    d =new Department();
			    d.setDeptID(rs.getInt("DeptID"));
			    d.setDeptName(rs.getString("DeptName"));
			    lst.add(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lst;
	}

}

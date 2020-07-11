package com.crudoperations.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.crudoperations.dto.Employee;

public class EmployeeDAO {
	Connection con;
	PreparedStatement pst;
	public String createEmployee(Employee emp) {
		con = DaoConnection.getConnection();
		String cmd = "insert into Employee (EmpID,EmpName,DID) values(?,?,?)";
		String result = "";
		try {
			pst =con.prepareStatement(cmd);
			pst.setInt(1, emp.getEmpID());
			pst.setString(2, emp.getEmpName());
			pst.setInt(3, emp.getDID());
			pst.executeUpdate();
			result ="Employee Added Successfully";
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return result;
	}
	public String updateEmployee(int dID,int empID, String empName) {
		 con = DaoConnection.getConnection();
		 String cmd = "update Employee set EmpName=? where DID=? and EmpID=?";
		 String result = "";
		 try {
			pst = con.prepareStatement(cmd);
			pst.setString(1, empName);
			pst.setInt(2, dID);
			pst.setInt(3, empID);
			pst.executeUpdate();
			result = "Employee details updated";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public String deleteEmployee(int DID,int EmpID) {
		con = DaoConnection.getConnection();
		String cmd = "delete from Employee where DID=? and EmpID=? ";
		String result = "";
		try {
			pst = con.prepareStatement(cmd);
			pst.setInt(1, DID);
			pst.setInt(2, EmpID);
			pst.executeUpdate();
			result = "Employee details deleted Successfully";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public List<Employee> getAllEmployees(int DID) {
		con = DaoConnection.getConnection();
		String cmd = "select * from Employee where DID=?";
		String result = "";
		List<Employee> lst = new ArrayList<Employee>();
		try {
			pst = con.prepareStatement(cmd);
			System.out.println(DID);
			pst.setInt(1, DID);
			ResultSet rs=pst.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(rs.getInt("EmpID"),rs.getString("EmpName"),rs.getInt("DID"));
				lst.add(emp);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return lst;
	}
   
}

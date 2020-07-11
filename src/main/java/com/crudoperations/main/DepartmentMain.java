package com.crudoperations.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.crudoperations.dto.Department;
import com.crudoperations.dto.Employee;
import com.crudoperations.service.DepartmentSer;
import com.crudoperations.service.EmployeeSer;

public class DepartmentMain {

	public static void main(String[] args) {
		int DeptID;
		String DeptName;
		Department d = new Department();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Department Details   : ");
		System.out.println("Enter the DeptID   : ");
		d.setDeptID(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter the DeptName   :");
		d.setDeptName(sc.nextLine());
		System.out.println(DepartmentSer.createDepartment(d));

		
        System.out.println("Enter the New Details to Update in database");
		System.out.println("Enter DeptName :");
		DeptName = sc.nextLine();
		System.out.println("Enter DeptID :");
		DeptID = Integer.parseInt(sc.nextLine());
		System.out.println(DepartmentSer.updateDepartment(DeptName, DeptID));

		
        System.out.println("Records present in Department are   :");
		System.out.println(DepartmentSer.getAllDepartments());

		
        System.out.println("Enter the department id to delete the record");
		System.out.println("Enter DeptID :");
		DeptID = Integer.parseInt(sc.nextLine());
		System.out.println(DepartmentSer.deleteDepartment(DeptID));

		

		Employee e = new Employee();
		System.out.println("Enter the Employee Details to insert into database   :");
		System.out.println("Enter the Employee deptid:");
		e.setDID(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter the Emp ID:");
		e.setEmpID(Integer.parseInt(sc.nextLine()));
		System.out.println("Enter the Emp Name");
		e.setEmpName(sc.nextLine());
		System.out.println(EmployeeSer.createEmployee(e));

		
        System.out.println("Enter the new details you want to update     :");
		System.out.println("Enter the departmentID:");
		int diD = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Emplyee ID:");
		int empID = Integer.parseInt(sc.nextLine());
		System.out.println("Enter the Employee Name:");
		String empName = sc.nextLine();

		System.out.println(EmployeeSer.updateEmployee(diD, empID, empName));

		
        System.out.println("Enter the department id to print all the employee details belong to that department   :");
		int DID;
		System.out.println("Enter DID: ");
		DID = sc.nextInt();
		List<Employee> lst = new ArrayList<Employee>();
		lst = EmployeeSer.getAllEmployees(DID);
		for (Employee employee : lst) {
			if(employee!=null) {
			System.out.println(employee.getEmpID());
			System.out.println(employee.getEmpName());
			}
			else
			{
				System.out.println("Employee Not Found");
			}
		}

		
        System.out.println("Enter the department&Employee id to delete the record   :");
		System.out.println("Enter DID:");
		DID = (sc.nextInt());
		System.out.println("Enter EmpID");
		int EmpID = sc.nextInt();
		System.out.println(EmployeeSer.deleteEmployee(DID, EmpID));

		

	}
}

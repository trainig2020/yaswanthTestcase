package com.crudoperations.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.crudoperations.dto.Department;
import com.crudoperations.dto.Employee;
import com.crudoperations.service.DepartmentSer;
import com.crudoperations.service.EmployeeSer;

public class EmployeeDAOTest {
    Employee e = new Employee();
	@Test
	public void testCreateEmployee() {
		e.setEmpID(203);
		e.setEmpName("ramadevi");
		e.setDID(8);
		assertEquals("Employee Added Successfully", EmployeeSer.createEmployee(e));
	}

	@Test
	public void testUpdateEmployee() {
		assertEquals("Employee details updated", EmployeeSer.updateEmployee(8, 202, "nihil"));
	}

	@Test
	public void testDeleteEmployee() {
		assertEquals("Employee details deleted Successfully", EmployeeSer.deleteEmployee(8, 121));
	}

	@Test
	public void testGetAllEmployees() {
		e.setDID(8);
		List<Employee> lst = EmployeeSer.getAllEmployees(8);
		for (Employee employee : lst) {
			System.out.println(employee.getEmpID());
			System.out.println(employee.getEmpName());
			System.out.println(employee.getDID());
		}
		assertNotNull(lst);
	}
}

package com.crudoperations.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.crudoperations.dto.Department;
import com.crudoperations.service.DepartmentSer;

public class DepartmentDAOTest {
	Department d = new Department();

	@Test
	public void testCreateDepartment() {

		d.setDeptID(72);
		d.setDeptName("java");
		assertEquals("Department Details Added Successfully", DepartmentSer.createDepartment(d));
	}

	@Test
	public void testUpdateDepartment() {
		assertEquals("Department Updated successfully", DepartmentSer.updateDepartment("oracle", 72));
	}

	@Test
	public void testDeleteDepartment() {
		assertEquals("Department details deleted successfully",DepartmentSer.deleteDepartment(65));
	}

	@Test
	public void testGetAllDepartments() {
		List<Department> lst = DepartmentSer.getAllDepartments();
		for (Department dep : lst) {
			System.out.println(dep.getDeptID());
			System.out.println(dep.getDeptName());
		}
		assertNotNull(lst);
	}

}

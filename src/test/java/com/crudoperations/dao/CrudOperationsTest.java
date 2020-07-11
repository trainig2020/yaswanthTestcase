package com.crudoperations.dao;



import org.junit.Test;

import static org.junit.Assert.assertNotNull;

import org.junit.*;
public class CrudOperationsTest {

	@Test
	public void testDaoConnection(){
		assertNotNull(DaoConnection.getConnection());
	}
	
	
}

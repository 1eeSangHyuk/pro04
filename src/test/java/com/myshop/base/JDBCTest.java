package com.myshop.base;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JDBCTest {

	JDBCConn t1 = new JDBCConn();
	
	@Test
	public void testJDBC() {
		t1.testJDBC();
	}
}

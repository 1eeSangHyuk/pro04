package com.myshop.base;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class JDBCConn {

	private final static Logger logger = LoggerFactory.getLogger(JDBCConn.class);
	static {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	void testJDBC() {
		Connection conn;
		try {
			conn = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3308/myshop?serverTimezone=Asia/seoul", "root", "1234");
			if (conn!=null) {
				logger.info("mariaDB 연결 성공");
			} else {
				logger.info("mariaDB 연결 실패");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}

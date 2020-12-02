package com.sqld.pettime.util;

import org.apache.ibatis.session.SqlSession;
import org.springframework.security.crypto.password.PasswordEncoder;

public class DBSession {
	// MyBatis �� SqlSession
		public static SqlSession sqlSession;
		public static PasswordEncoder passwordEncoder;
}

package com.chinasoft.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionUtil {

	private  static SqlSessionFactory  factory;
	
	
	public SessionUtil() {
		super();
		// TODO Auto-generated constructor stub
	}

	public  static  SqlSessionFactory  getSession() {
		try {
			String resource = "mybatis-config.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(inputStream);
			return factory;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
}	

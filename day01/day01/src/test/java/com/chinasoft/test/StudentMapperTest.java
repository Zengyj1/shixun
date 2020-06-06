package com.chinasoft.test;

import com.chinasoft.mapper.StudentMapper;
import com.chinasoft.pojo.Student;
import com.chinasoft.util.SessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;

public class StudentMapperTest {
	public  SqlSessionFactory factory = SessionUtil.getSession();

	//运行会报错
	@Test
	public void selectAllStudent() {
		SqlSession session = factory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		List<Student> students = mapper.SelectAllStudent();
		for (Student student : students) {
			System.out.println(student);
		}
		session.close();
	}
	
	
	@Test
	public void selectOneStudentWithGender() {
		SqlSession session = factory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		Student student = mapper.SelectOneAll(5);
		System.out.println(student);
		session.close();
	}

	@Test
	public void select(){
		SqlSession session = factory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		List<Student> students=mapper.Select(2);
		for (Student student : students) {
			System.out.println(student);
		}
		session.close();
	}
	
}

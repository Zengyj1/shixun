package com.chinasoft.mapper;

import com.chinasoft.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {
	
	//加上下面这句后SelectAllStudent可以运行,但user，cid，pwd和数据库字段名不一样，运行时为null
	 //@Select("select * from student")
	//查看学生表的内容
	List<Student> SelectAllStudent();

	//查看某个学生的信息
	Student SelectOneAll(int id);

	List<Student> Select(int id);
	
}

package com.chinasoft.mapper;

import java.util.List;

import com.chinasoft.pojo.Student;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.chinasoft.pojo.User;

public interface UserMapper {
	//
	void addUserNoPar();
	//
	void addUserByPar(User user);
	//
	User selectOneByPar(int id);
	//查询所有用户，使用java注解
	@Select("select * from user")
	List<User>  selectAll();
	
	
	//登录功能
	User selectLogin(User user);
	
	//根据username排序，需要加注解
	List<User> selectOrderBy(@Param("column")String column);

	User findUserActive(User user);


	//查询用户为一些对应id的(list)
	List<User> findUsersWithList(List<Integer> list);

	//分页功能查询
    List<User> selectWithPage(int cid);

    //动态添加用户
    void addUserWithIf(User users);


}

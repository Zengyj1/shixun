package com.chinasoft.test;

import java.util.ArrayList;
import java.util.List;

import com.chinasoft.mapper.StudentMapper;
import com.chinasoft.pojo.Student;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import com.chinasoft.mapper.UserMapper;
import com.chinasoft.pojo.User;
import com.chinasoft.util.SessionUtil;

public class UserMapperTest {
	public SqlSessionFactory factory = SessionUtil.getSession();

	public void addUserNoPar() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.addUserNoPar();
		session.commit();
		session.close();
	}

	public void addUserByPar() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User(25, "asd", "liming111", "6666666", "123qwqe", "723872387@qq.com", 1);
		mapper.addUserByPar(user);
		session.commit();
		session.close();
	}

	@Test
	public void selectOneByPar() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.selectOneByPar(5);
		System.out.println(user);

		session.clearCache();
		//清理缓存后就会再执行一遍sql语句
		User user1=mapper.selectOneByPar(5);
		System.out.println(user1);//执行第二条

		session.close();
	}

	//使用java注释进行配置，在interface中完成，就不需要再xml文件中配置
	public void selectAll() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> list = mapper.selectAll();
		for (User user : list) {
			System.out.println(user);
		}
		session.close();
	}

	//使用@Test就不用main方法
	@Test
	public void selectLogin() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("刘德华");
		user.setPassword("123456");
		User user1 = mapper.selectLogin(user);
		System.out.println(user1);
		session.close();
	}

	//可以根据不同的列来排序，此处选择的是username
	@Test
	public void selectOrderBy() {
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> users = mapper.selectOrderBy("id");
		for (User user : users) {
			System.out.println(user);
		}
		session.close();
	}

	@Test
	public  void selectOneByParCache(){
		SqlSession session = factory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user = mapper.selectOneByPar(5);
		System.out.println(user);
		session.close();

		SqlSession session1 = factory.openSession();
		UserMapper mapper1 = session1.getMapper(UserMapper.class);
		User user1 = mapper1.selectOneByPar(5);
		System.out.println(user1);
		session1.close();

	}

	//测试动态sqlif,可能有错
	public void findActive(){
		SqlSession session=factory.openSession();
		UserMapper mapper= session.getMapper(UserMapper.class);
		User user =new User();
		user.setUsername("lol");
		mapper.findUserActive(user);

	}

	@Test
	public void findUserWithList(){
		SqlSession session=factory.openSession();
		UserMapper mapper= session.getMapper(UserMapper.class);
		List<Integer> list=new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		List<User>  users=mapper.findUsersWithList(list);
		for (User user:users){
			System.out.println(user);
		}

	}

	//动态添加
	@Test
    public void addUserWithIf(){
        SqlSession session=factory.openSession();
        UserMapper mapper= session.getMapper(UserMapper.class);
        User user1=new User();
        user1.setUsername("曾毅君1");
        user1.setPassword("123123");
        user1.setEmail("724290474@qq.com");
        mapper.addUserWithIf(user1);

        User user2=new User();
        user2.setUsername("曾毅君2");
        user2.setPassword("456456");
        mapper.addUserWithIf(user2);
        session.commit();
        session.close();
    }

	//分页功能查询每页5个
    @Test
	public void selectWithPage(){
		SqlSession session=factory.openSession();
		UserMapper mapper= session.getMapper(UserMapper.class);
		List<User> users = mapper.selectWithPage(1);
		for (User user:users){
			System.out.println(user);
		}

	}


	//1：根据学习的多对一关联查询，完成一对多关联查询
	public static void main(String[] args) {
		// new UserMapperTest().addUserNoPar();
		 //new UserMapperTest().addUserByPar();
		// new UserMapperTest().selectOneByPar();
		// new UserMapperTest().selectOneByPar();
		new UserMapperTest().selectAll();
	}

}

package com.chinasoft.test;

import com.chinasoft.pojo.Gender;
import com.chinasoft.util.SessionUtil;
import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class GenderMapper {
    public SqlSessionFactory factory = SessionUtil.getSession();

    @Test
    public void testSelectGenderWithUser() {
        SqlSession session = factory.openSession();
        com.chinasoft.mapper.GenderMapper mapper = session.getMapper(com.chinasoft.mapper.GenderMapper.class);
        Gender gender = mapper.selectGenderWithUser(1);
        System.out.println(gender);
        session.close();
    }
}

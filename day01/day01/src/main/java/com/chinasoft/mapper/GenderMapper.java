package com.chinasoft.mapper;

import com.chinasoft.pojo.Gender;

import java.util.List;
import org.apache.ibatis.annotations.Select;


public interface GenderMapper {
    Gender selectGenderWithUser(int id);
}

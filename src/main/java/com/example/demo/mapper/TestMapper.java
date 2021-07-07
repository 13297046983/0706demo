package com.example.demo.mapper;

import com.example.demo.bean.Test;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TestMapper {
    @Select("select * from user")
    List<Test> finAll();

    @Select("select * from user where uid=#{id}")
    Test find_user(Integer id);
}

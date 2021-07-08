package com.example.demo.mapper;

import com.example.demo.bean.Test;
import com.example.demo.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PageMapper {
    @Select("select * from user")
    List<Test>findById();
}

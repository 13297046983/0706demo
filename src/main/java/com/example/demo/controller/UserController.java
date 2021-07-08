package com.example.demo.controller;

import com.example.demo.bean.Result;
import com.example.demo.bean.Test;
import com.example.demo.bean.User;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.impl.PageServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    private PageServiceImpl pageService;

    @RequestMapping("/findAll")
    public List<Test>findAll(){
        return testMapper.finAll();
    }
    @RequestMapping("/find_user")
    public Test find_user(Integer id){
        return testMapper.find_user(id);
    }
    @GetMapping("/getUser")
    public List<User>getUser(){
        User user=new User(2,"张三","12345","男");
        List<User> list=new ArrayList();
        list.add(user);
        return list;
    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/getUser1")
    public Result<User>getUser1(){
        User user=new User(1,"张三","12345","男");
        return new Result<>(user);
    }
    @GetMapping("/page")
    public PageInfo SelectPage( com.example.demo.bean.PageInfo pageInfo){
        return pageService.findByIdPage(pageInfo);
    }
}

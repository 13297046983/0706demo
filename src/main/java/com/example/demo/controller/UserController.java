package com.example.demo.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.example.demo.bean.PageInfos;
import com.example.demo.bean.Result;
import com.example.demo.bean.Test;
import com.example.demo.bean.User;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.impl.PageServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private TestMapper testMapper;
    @Autowired
    public PageServiceImpl pageService;
    @RequestMapping("/findAll")
    @ResponseBody
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
    public PageInfo SelectPage(PageInfos pageInfo){
       return pageService.findAllPage(pageInfo);
   }

   @RequestMapping("/tologin")
    public String tologin(String username,String password){
        //跳过登录验证
        if("zhang".equals(username)&&"123".equals(password)){
            StpUtil.login(1);
            return "登录成功";
        }
        return "登录失败";
    }
    @RequestMapping("/islogin")
    public String islogin(){
        return "当前账号是否登录"+StpUtil.isLogin();
    }
}

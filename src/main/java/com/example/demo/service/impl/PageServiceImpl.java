package com.example.demo.service.impl;

import com.example.demo.bean.Test;
import com.example.demo.bean.User;
import com.example.demo.mapper.PageMapper;
import com.example.demo.service.PageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    public PageMapper pageMapper;
    @Override
    public PageInfo findByIdPage(com.example.demo.bean.PageInfo pageInfo) {
        //PageHelper.startPage(1,3);
        List<Test> list=pageMapper.findById();

        PageInfo<Test>info=new PageInfo<>(list);
        return info;
    }
}

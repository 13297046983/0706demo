package com.example.demo.service.impl;

import com.example.demo.bean.PageInfos;
import com.example.demo.bean.Test;
import com.example.demo.mapper.TestMapper;
import com.example.demo.service.PageService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService{
    @Autowired
    public TestMapper testMapper;
    @Override
    public PageInfo findAllPage(PageInfos pageInfos) {
        PageHelper.startPage(pageInfos.getPageNum(),pageInfos.getPageSize());
        List<Test> list=testMapper.finAll();
        PageInfo<Test>pageInfo=new PageInfo<>(list);
        return pageInfo;
    }
}

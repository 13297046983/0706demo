package com.example.demo.service;

import com.github.pagehelper.PageInfo;

public interface PageService {

    PageInfo findByIdPage(com.example.demo.bean.PageInfo pageInfo);

}

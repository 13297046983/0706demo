package com.example.demo.service;

import com.example.demo.bean.PageInfos;
import com.github.pagehelper.PageInfo;

public interface PageService {

    PageInfo findAllPage(PageInfos pageInfos);
}

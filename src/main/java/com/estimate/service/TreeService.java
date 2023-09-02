package com.estimate.service;

import com.estimate.pojo.Egrade;
import com.estimate.pojo.OlderTree;
import com.estimate.pojo.PageBean;

import java.util.List;

public interface TreeService {
    List<OlderTree> getAll();

    PageBean<Egrade> selectTreePageAndCondition(int currentPage,int pageSize,Egrade e);
}

package com.estimate.service;

import com.estimate.pojo.Older;
import com.estimate.pojo.PageBean;

import java.util.List;

public interface OlderService {
    public List<Older> getAll();

//    分页
    PageBean<Older> selectByPage(int currentPage,int pageSize);

//    数据添加
    void add_estimate(Older older);

//    删除
    void deleteOlder(String id);

//    修改登记信息
    void updateOlder(Older older);

//    老年人登记条件查询
    PageBean<Older> selectByPageandCondition(int currentPage,int pageSize,Older older);
}

package com.estimate.service;

import com.estimate.pojo.Egrade;
import com.estimate.pojo.PageBean;

import java.util.List;

public interface EgradeService {

    List<Egrade> getDailylife();

    List<Egrade> getPsychosis();

    List<Egrade> getSense();

    List<Egrade> getInvolve();

    List<Egrade> getColumnar();

    Egrade getByRegno(String regno);

    void updateDaily(Egrade egrade);

    void updatePsychosis(Egrade e);

    void updateSense(Egrade e);

    void updateInvolve(Egrade e);

    PageBean<Egrade> selectByPage(int currentPage,int pageSize);

    PageBean<Egrade> selectPageAndCondition(int currentPage, int pageSize, Egrade egrade);

    //日常生活，可视化图表使用 表格重载
    PageBean<Egrade> selectPageByDaily(int currentPage,int pageSize,String dailylife);

    PageBean<Egrade> selectPageByPsychosis(int currentPage,int pageSize,String psychosis);

    PageBean<Egrade> selectPageBySense(int currentPage,int pageSize,String sense);

    PageBean<Egrade> selectPageByInvolve(int currentPage,int pageSize,String involve);

    boolean addOlder(Egrade egrade);
}

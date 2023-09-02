package com.estimate.service.impl;

import com.estimate.mapper.EgradeMapper;
import com.estimate.pojo.Egrade;
import com.estimate.pojo.PageBean;
import com.estimate.service.EgradeService;
import com.estimate.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class EgradeServiceImpl implements EgradeService {

    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Egrade> getDailylife() {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        List<Egrade> list = mapper.getDailylife();
        sqlSession.close();
        return list;
    }

    @Override
    public List<Egrade> getPsychosis() {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        List<Egrade> psychosis = mapper.getPsychosis();
        sqlSession.close();
        return psychosis;
    }

    @Override
    public List<Egrade> getSense() {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        List<Egrade> sense = mapper.getSense();
        return sense;
    }

    @Override
    public List<Egrade> getInvolve() {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        List<Egrade> involve = mapper.getInvolve();
        return involve;
    }

    @Override
    public List<Egrade> getColumnar() {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        List<Egrade> columnar = mapper.getColumnar();
        return columnar;
    }

    @Override
    public Egrade getByRegno(String regno) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        Egrade egrade = mapper.getByRegno(regno);
        return egrade;
    }

    @Override
    public void updateDaily(Egrade egrade) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        mapper.updateDailylife(egrade);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updatePsychosis(Egrade e) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        mapper.updatePsychosis(e);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateSense(Egrade e) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        mapper.updateSense(e);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateInvolve(Egrade e) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        mapper.updateInvolve(e);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Egrade> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        List<Egrade> list = mapper.selectPage(begin, size);
        int count = mapper.totalCountByPage();
        PageBean<Egrade> pageBean = new PageBean<>();
        pageBean.setRows(list);
        pageBean.setTotalCount(count);
        return pageBean;
    }

    @Override
    public PageBean<Egrade> selectPageAndCondition(int currentPage, int pageSize, Egrade egrade) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        String oldername = egrade.getOldername();
        String regno = egrade.getRegno();
        String enumber = egrade.getEnumber();
        if (oldername != null && oldername.length() > 0) {
            egrade.setOldername("%" + oldername + "%");
        }
        List<Egrade> list = mapper.selectPageAndCondition(begin, size, egrade);
        int total = mapper.selectTotalByCondition();
        PageBean<Egrade> pageBean = new PageBean<>();
        pageBean.setRows(list);
        pageBean.setTotalCount(total);
        return pageBean;
    }

    @Override
    public PageBean<Egrade> selectPageByDaily(int currentPage, int pageSize, String dailylife) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        dailylife = "%" + dailylife + "%";
        List<Egrade> list = mapper.selectPageByDaily(begin, size, dailylife);
        int total = mapper.selectTotalByDaily(dailylife);
        PageBean<Egrade> pageBean = new PageBean<>();
        pageBean.setRows(list);
        pageBean.setTotalCount(total);
        return pageBean;
    }

    @Override
    public PageBean<Egrade> selectPageByPsychosis(int currentPage, int pageSize, String psychosis) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        psychosis = "%" + psychosis + "%";
        List<Egrade> list = mapper.selectPageByPsychosis(begin, size, psychosis);
        int total = mapper.selectTotalByDaily(psychosis);
        PageBean<Egrade> pageBean = new PageBean<>();
        pageBean.setRows(list);
        pageBean.setTotalCount(total);
        return pageBean;
    }

    @Override
    public PageBean<Egrade> selectPageBySense(int currentPage, int pageSize, String sense) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        sense = "%" + sense + "%";
        List<Egrade> list = mapper.selectPageBySense(begin, size, sense);
        int total = mapper.selectTotalByDaily(sense);
        PageBean<Egrade> pageBean = new PageBean<>();
        pageBean.setRows(list);
        pageBean.setTotalCount(total);
        return pageBean;
    }

    @Override
    public PageBean<Egrade> selectPageByInvolve(int currentPage, int pageSize, String involve) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        involve = "%" + involve + "%";
        List<Egrade> list = mapper.selectPageByInvolve(begin, size, involve);
        int total = mapper.selectTotalByDaily(involve);
        PageBean<Egrade> pageBean = new PageBean<>();
        pageBean.setRows(list);
        pageBean.setTotalCount(total);
        return pageBean;
    }

    @Override
    public boolean addOlder(Egrade egrade) {
        SqlSession sqlSession = factory.openSession();
        EgradeMapper mapper = sqlSession.getMapper(EgradeMapper.class);
        int count = mapper.selectByRegno(egrade);
        if (count != 0) {
            sqlSession.close();
            return false;
        } else {
            mapper.add(egrade);
            sqlSession.commit();
            sqlSession.close();
            return true;
        }
    }
}

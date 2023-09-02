package com.estimate.service.impl;

import com.estimate.mapper.OlderMapper;
import com.estimate.pojo.Older;
import com.estimate.pojo.PageBean;
import com.estimate.service.OlderService;
import com.estimate.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class OlderServiceImpl implements OlderService {

    private SqlSessionFactory factory= SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<Older> getAll() {
        SqlSession sqlSession = factory.openSession();
        OlderMapper mapper = sqlSession.getMapper(OlderMapper.class);
        List<Older> olders = mapper.getAll();
        sqlSession.close();
        return olders;
    }

    @Override
    public PageBean<Older> selectByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        OlderMapper mapper = sqlSession.getMapper(OlderMapper.class);

        int begin = (currentPage - 1)*pageSize;
        int size = pageSize;
        List<Older> rows = mapper.getByPage(begin, size);
        int totalCont = mapper.selectTotalCont();
        PageBean<Older> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(totalCont);
        sqlSession.close();
        return pageBean;
    }

    @Override
    public void add_estimate(Older older) {
        SqlSession sqlSession = factory.openSession();
        OlderMapper mapper = sqlSession.getMapper(OlderMapper.class);

        mapper.AddEstimate(older);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void deleteOlder(String  id) {
        SqlSession sqlSession = factory.openSession();
        OlderMapper mapper = sqlSession.getMapper(OlderMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void updateOlder(Older older) {
        SqlSession sqlSession = factory.openSession();
        OlderMapper mapper = sqlSession.getMapper(OlderMapper.class);
        mapper.updateOlder(older);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<Older> selectByPageandCondition(int currentPage, int pageSize, Older older) {
        SqlSession sqlSession = factory.openSession();
        OlderMapper mapper = sqlSession.getMapper(OlderMapper.class);

        int begin = (currentPage - 1)*pageSize;
        int size = pageSize;
        String estimate_id = older.getEstimate_id();
        if(estimate_id != null && estimate_id.length()>0){
            older.setEstimate_id("%"+estimate_id+"%");
        }
        String estimate_name = older.getEstimate_name();
        if(estimate_name != null && estimate_name.length()>0){
            older.setEstimate_name(estimate_name);
        }
        List<Older> rows = mapper.getByPageandCondition(begin, size, older);
        int total = mapper.selectConditionTotalCount();
        PageBean<Older> pageBean = new PageBean<>();
        pageBean.setRows(rows);
        pageBean.setTotalCount(total);
        sqlSession.close();
        return pageBean;
    }

}

package com.estimate.service.impl;

import com.estimate.mapper.EgradeMapper;
import com.estimate.mapper.TreeMapper;
import com.estimate.pojo.Egrade;
import com.estimate.pojo.OlderTree;
import com.estimate.pojo.PageBean;
import com.estimate.service.TreeService;
import com.estimate.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.ArrayList;
import java.util.List;

public class TreeServiceImpl implements TreeService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public List<OlderTree> getAll() {
        SqlSession sqlSession = factory.openSession();
        TreeMapper mapper = sqlSession.getMapper(TreeMapper.class);
        List<OlderTree> trees = mapper.getAll();
        sqlSession.close();
        List<OlderTree> list = new ArrayList<>();
        OlderTree ot;
        for (OlderTree tree : trees) {
            ot = new OlderTree(tree.getId(), tree.getTitle(), tree.getPid());
            list.add(ot);
        }
        return buildTree(list, "0");
    }

    public List<OlderTree> buildTree(List<OlderTree> list, String pid) {
        List<OlderTree> treeList = new ArrayList<>();
        for (OlderTree tree : list) {
            if(tree.getPid().equals(pid)){
                tree.setChildren(buildTree(list,tree.getId()));
                treeList.add(tree);
            }
        }
        return treeList;
    }

    @Override
    public PageBean<Egrade> selectTreePageAndCondition(int currentPage, int pageSize, Egrade e) {
        SqlSession sqlSession = factory.openSession();
        TreeMapper mapper = sqlSession.getMapper(TreeMapper.class);
        int begin = (currentPage - 1) * pageSize;
        int size = pageSize;
        String dailylife = e.getDailylife();
        if(dailylife!=null && dailylife.length()>0){
            e.setDailylife("%"+dailylife+"%");
        }
        String psychosis = e.getPsychosis();
        if(psychosis!=null && psychosis.length()>0){
            e.setPsychosis("%"+psychosis+"%");
        }
        String sense = e.getSense();
        if(sense!=null && sense.length()>0){
            e.setSense("%"+sense+"%");
        }
        String involve = e.getInvolve();
        if(involve!=null && involve.length()>0){
            e.setInvolve("%"+involve+"%");
        }
        List<Egrade> list = mapper.selectTreePageAndCondition(begin, size, e);
        int treeTotal = mapper.selectTreeTotal(e);
        PageBean<Egrade> pageBean = new PageBean<>();
        pageBean.setRows(list);
        pageBean.setTotalCount(treeTotal);
        return pageBean;
    }
}

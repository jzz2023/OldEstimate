package com.estimate.service.impl;

import com.estimate.mapper.UserMapper;
import com.estimate.pojo.PageBean;
import com.estimate.pojo.User;
import com.estimate.service.UserService;
import com.estimate.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class UserServiceImpl implements UserService {
    private SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    @Override
    public boolean login(User user) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> list = mapper.findByUsername(user);
        boolean flag = false;
        if(list.isEmpty()){
            flag = false;
        }else {
            flag = true;
        }
        sqlSession.close();
        return flag;
    }

    @Override
    public void register(User user) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.addUser(user);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public PageBean<User> findByPage(int currentPage, int pageSize) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size=pageSize;
        List<User> users = mapper.findByPage(begin, size);
        int total = mapper.selectPageTotal();
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setRows(users);
        pageBean.setTotalCount(total);
        sqlSession.close();
        return pageBean;
    }

    @Override
    public PageBean<User> findByPageandCondition(int currentPage, int pageSize, User user) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int begin=(currentPage-1)*pageSize;
        int size=pageSize;
        String username = user.getUsername();
        if(username!=null && username.length()>0){
            user.setUsername("%"+username+"%");
        }
        List<User> pageandCondition = mapper.findByPageandCondition(begin, size, user);
        int totalCondition = mapper.selectTotalCondition(user);
        PageBean<User> pageBean = new PageBean<>();
        pageBean.setTotalCount(totalCondition);
        pageBean.setRows(pageandCondition);
        sqlSession.close();
        return pageBean;
    }

    @Override
    public void resetPwd(int id) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.updatePwd(id);
        sqlSession.commit();
        sqlSession.close();
    }

    @Override
    public void delUser(int id) {
        SqlSession sqlSession = factory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }

}

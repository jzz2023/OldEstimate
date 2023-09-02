package com.estimate.mapper;

import com.estimate.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    //登录
    List<User> findByUsername(@Param("user") User user);

    //注册
    void addUser(User user);

    //查看所有用户
    List<User> findByPage(@Param("begin") int begin,@Param("size") int size);
    int selectPageTotal();

    //条件查询
    List<User> findByPageandCondition(@Param("begin") int begin,@Param("size") int size,@Param("user") User user);
    int selectTotalCondition(User user);

    //密码重置
    @Update("update user set pwd = '123456' where id = #{id}")
    void updatePwd(int id);

    //删除用户
    @Delete("delete from user where id = #{id}")
    void deleteById(int id);
}

package com.estimate.mapper;

import com.estimate.pojo.Older;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface OlderMapper {

    @Select("select * from older")
    public List<Older> getAll();

    //分页查询
    List<Older> getByPage(@Param("begin") int begin, @Param("size") int size);

//  查询总记录数
    int selectTotalCont();

    //添加数据
    @Insert("insert into older values (#{estimate_id},#{es_date},#{es_case},#{estimate_name},#{sex}," +
            "#{es_birth},#{IDCard},#{card},#{nation},#{educate},#{orgion},#{marry},#{live_status}," +
            "#{medical},#{economy},#{sick},#{accident},#{p_name},#{relation},#{r_name},#{r_phone})")
    void AddEstimate(Older older);

//    删除评估表
    @Delete("delete from older where estimate_id = #{estimate_id}")
    void deleteById(String id);

    //修改登记信息
    void updateOlder(Older older);

    //分页条件查询
    List<Older> getByPageandCondition(@Param("begin") int begin,@Param("size") int size,@Param("older") Older older);

    int selectConditionTotalCount();
}

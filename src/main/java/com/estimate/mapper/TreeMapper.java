package com.estimate.mapper;

import com.estimate.pojo.Egrade;
import com.estimate.pojo.OlderTree;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TreeMapper {
    List<OlderTree> getAll();

//    进行树形结构分页条件查询
    List<Egrade> selectTreePageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("egrade") Egrade egrade);

    int selectTreeTotal(Egrade egrade);
}

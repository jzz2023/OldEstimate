package com.estimate.mapper;

import com.estimate.pojo.Egrade;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface EgradeMapper {
    //进行查询，显示图表内容
    List<Egrade> getDailylife();

    List<Egrade> getPsychosis();

    List<Egrade> getSense();

    List<Egrade> getInvolve();

    //获取老人姓名和评估次数
    List<Egrade> getColumnar();

    Egrade getByRegno(@Param("regno") String regno);

    //对日常生活进行评估
    void updateDailylife(Egrade egrade);

    //精神状态评估
    void updatePsychosis(Egrade egrade);

    //感知觉评估
    void updateSense(Egrade egrade);

    //社会参与评估
    void updateInvolve(Egrade egrade);

    //分页显示
    List<Egrade> selectPage(@Param("begin") int begin,@Param("size") int size);

    int totalCountByPage();

    //条件查询
    List<Egrade> selectPageAndCondition(@Param("begin") int begin, @Param("size") int size, @Param("egrade") Egrade egrade);

    int selectTotalByCondition();

    //根据图表进行条件查询
    //根据日常生活
    List<Egrade> selectPageByDaily(@Param("begin") int begin,@Param("size") int size,@Param("dailylife") String dailylife);
    int selectTotalByDaily(@Param("dailylife") String dailylife);

    List<Egrade> selectPageByPsychosis(@Param("begin") int begin,@Param("size") int size,@Param("psychosis") String psychosis);
    int selectTotalByPsychosis(@Param("psychosis")String psychosis);

    List<Egrade> selectPageBySense(@Param("begin") int begin, @Param("size") int size, @Param("sense") String sense);
    int selectTotalBySense(@Param("sense")String sense);

    List<Egrade> selectPageByInvolve(@Param("begin") int begin,@Param("size") int size,@Param("involve") String involve);
    int selectTotalByInvolve(@Param("involve")String involve);

    @Insert("insert into egrade(oldername,regno,enumber) values(#{oldername},#{regno},#{enumber}) ")
    void add(Egrade egrade);

    @Select("select count(*) from egrade where regno = #{regno}")
    int selectByRegno(Egrade egrade);
}

package com.sys.demo01.dao;

import com.sys.demo01.pojo.Gcmc;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GcmcDao {
    @Select("SELECT gcmc_id,gcmc_name,khmc_id FROM gcmc")
    public List<Gcmc> getAll();

    @Select("SELECT gcmc_id,gcmc_name,khmc_id FROM gcmc WHERE khmc_id = #{khmc_id}")
    public List<Gcmc> getGcmcsByKhId(@RequestParam("khmc_id") Long khmc_id);

    @Select("<script>" +
            "select * from gcmc " +
            " <where>" +
            "<if test=\"khmc_id != 0\"> and khmc_id = #{khmc_id}</if>" +
            "<if test=\"gcmc_name != null and gcmc_name != ''\"> and gcmc_name like concat('%',#{gcmc_name},'%')</if>" +
            "</where>" +
            "</script>")
    public List<Gcmc> getGcmcs(@RequestParam("khmc_id") Long khmc_id, @RequestParam("gcmc_name") String gcmc_name);

    @Insert("INSERT INTO gcmc(gcmc_name,khmc_id) VALUES(#{gcmc_name},#{khmc_id})")
    public int add(Gcmc gcmc);

    @Update("UPDATE gcmc SET gcmc_name = #{gcmc_name},khmc_id = #{khmc_id} WHERE gcmc_id=#{gcmc_id}")
    public int update(Gcmc gcmc);

    @Delete("<script>" +
            "DELETE FROM gcmc WHERE gcmc_id in " +
            "<foreach collection=\"array\" item=\"id\" open=\"(\" close=\")\" separator=\",\" >" +
            "#{id}" +
            "</foreach>" +
            "</script>")
    public int delete(int[] ids);

    public Gcmc getGcmcById(@Param("gcmc_id") Long gcmc_id);
}

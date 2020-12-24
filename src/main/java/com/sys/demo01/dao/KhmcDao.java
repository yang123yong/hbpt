package com.sys.demo01.dao;

import com.sys.demo01.pojo.Khmc;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface KhmcDao {
    /**
     * 根据客户id得到客户名称
     *
     * @param khmc_id
     * @return
     */
    //@Select("select * from khmc where khmc_id= #{khmc_id}")
    public Khmc selectKhmcById(@Param("khmc_id") Long khmc_id);

    /**
     * 得到所有客户名称
     *
     * @return
     */
    @Select("select * from khmc")
    public List<Khmc> getAll();

    /**
     * 添加
     *
     * @param khmc
     * @return
     */
    @Insert("insert into khmc(khmc_name) values(#{khmc_name})")
    public int addKhmc(Khmc khmc);

    /**
     * 删除
     *
     * @param khmc_id
     * @return
     */
    public int delKhmc(Long khmc_id);

}

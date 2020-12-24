package com.sys.demo01.dao;

import com.sys.demo01.pojo.Yclrk;
import com.sys.demo01.vo.YclrkVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface YclrkDao extends Mapper<Yclrk> {
    public List<YclrkVo> getYclrkVos();

    public List<YclrkVo> getYclrkVoList();

    public int updateYclrk(Yclrk yclrk);

    public int deleteYclrk(int[] ids);

    //@Select("select * from yclrk where yclrk_material_name like concat('%',#{ycl_name},'%')")
    public List<YclrkVo> getYclrkVoLists(@Param("ycl_name") String ycl_name);
}

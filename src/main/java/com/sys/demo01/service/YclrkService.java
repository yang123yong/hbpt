package com.sys.demo01.service;

import com.sys.demo01.pojo.Yclrk;
import com.sys.demo01.vo.YclrkVo;

import java.util.List;

public interface YclrkService {
    public List<Yclrk> getAll();

    public boolean addYclrk(Yclrk yclrk);

    public boolean updataYclrk(Yclrk yclrk);

    public boolean deleteYclrk(int[] ids);

    public List<YclrkVo> getYclrkVos();

    public List<YclrkVo> getYclrkVoList();

    public List<YclrkVo> getYclrk(String ycl_name);
}

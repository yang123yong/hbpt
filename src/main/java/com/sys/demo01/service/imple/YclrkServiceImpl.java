package com.sys.demo01.service.imple;

import com.sys.demo01.dao.YclrkDao;
import com.sys.demo01.pojo.Yclrk;
import com.sys.demo01.service.YclrkService;
import com.sys.demo01.vo.YclrkVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YclrkServiceImpl implements YclrkService {
    @Autowired
    private YclrkDao yclrkDao;

    @Override
    public List<Yclrk> getAll() {
        return yclrkDao.selectAll();
    }

    @Override
    public boolean addYclrk(Yclrk yclrk) {
        return yclrkDao.insertSelective(yclrk) == 1;
    }

    @Override
    public boolean updataYclrk(Yclrk yclrk) {
        return yclrkDao.updateYclrk(yclrk) == 1;
    }

    @Override
    public boolean deleteYclrk(int[] ids) {
        return yclrkDao.deleteYclrk(ids) == ids.length;
    }

    @Override
    public List<YclrkVo> getYclrkVos() {
        return yclrkDao.getYclrkVos();
    }

    @Override
    public List<YclrkVo> getYclrkVoList() {
        return yclrkDao.getYclrkVoList();
    }

    @Override
    public List<YclrkVo> getYclrk(String ycl_name) {
        return yclrkDao.getYclrkVoLists(ycl_name);
    }
}

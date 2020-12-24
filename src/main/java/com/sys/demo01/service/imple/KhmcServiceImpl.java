package com.sys.demo01.service.imple;

import com.sys.demo01.dao.KhmcDao;
import com.sys.demo01.pojo.Khmc;
import com.sys.demo01.service.KhmcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KhmcServiceImpl implements KhmcService {
    @Autowired
    private KhmcDao khmcDao;

    public Khmc selectKhmcById(Long khmc_id) {
        return khmcDao.selectKhmcById(khmc_id);
    }

    public void addKhmc(Khmc khmc) {
        khmcDao.addKhmc(khmc);
    }

    public int deleteKhmcById(Long khmc_id) {
        return khmcDao.delKhmc(khmc_id);
    }

    public List<Khmc> getAll() {
        return khmcDao.getAll();
    }
}

package com.sys.demo01.service.imple;

import com.sys.demo01.dao.GcmcDao;
import com.sys.demo01.pojo.Gcmc;
import com.sys.demo01.service.GcmcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GcmcServiceImpl implements GcmcService {
    @Autowired
    private GcmcDao gcmcDao;

    @Override
    public List<Gcmc> getAll() {
        return gcmcDao.getAll();
    }

    @Override
    public List<Gcmc> getGcmcsByKhId(Long khmc_id) {
        return gcmcDao.getGcmcsByKhId(khmc_id);
    }

    @Override
    public boolean add(Gcmc gcmc) {
        
        return gcmcDao.add(gcmc) == 1;
    }

    @Override
    public boolean update(Gcmc gcmc) {
        return gcmcDao.update(gcmc) == 1;
    }

    @Override
    public boolean delete(int[] ids) {
        return gcmcDao.delete(ids) == ids.length;
    }

    @Override
    public List<Gcmc> getGcmcs(Long khmc_id, String gcmc_name) {
        return gcmcDao.getGcmcs(khmc_id, gcmc_name);
    }
}

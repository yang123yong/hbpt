package com.sys.demo01.service;

import com.sys.demo01.pojo.Khmc;

import java.util.List;

public interface KhmcService {
    public Khmc selectKhmcById(Long khmc_id);

    public void addKhmc(Khmc khmc);

    public int deleteKhmcById(Long khmc_id);

    public List<Khmc> getAll();
}

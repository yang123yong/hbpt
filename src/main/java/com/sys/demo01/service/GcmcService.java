package com.sys.demo01.service;

import com.sys.demo01.pojo.Gcmc;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface GcmcService {

    public List<Gcmc> getAll();


    public List<Gcmc> getGcmcsByKhId(Long khmc_id);

    public List<Gcmc> getGcmcs(Long khmc_id, String gcmc_name);

    public boolean add(Gcmc gcmc);


    public boolean update(Gcmc gcmc);

    public boolean delete(int[] ids);
}

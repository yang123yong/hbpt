package com.sys.demo01.controller;

import com.github.pagehelper.PageHelper;
import com.sys.demo01.pojo.DataGridResult;
import com.sys.demo01.pojo.Gcmc;
import com.sys.demo01.service.GcmcService;
import com.sys.demo01.tools.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gcmc")
public class GcmcController {
    @Autowired
    private GcmcService gcmcService;

    @RequestMapping("getAll")
    public DataGridResult getAll(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                 @RequestParam(value = "rows", required = false, defaultValue = "10") int rows) {
        PageHelper.startPage(page, rows);
        return PageUtils.convertToResult(gcmcService.getAll());
    }

    @RequestMapping("getAll/lable")
    public List<Gcmc> getAll() {

        return gcmcService.getAll();
    }

    @RequestMapping("getGcmcsByKhId/{khmc_id}")
    public DataGridResult getGcmcsByKhId(
            @PathVariable("khmc_id") Long khmc_id,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "rows", required = false, defaultValue = "10") int rows) {
        PageHelper.startPage(page, rows);//开启mybatis分页插件
        return PageUtils.convertToResult(gcmcService.getGcmcsByKhId(khmc_id));
    }

    @PostMapping("add")
    public boolean add(Gcmc gcmc) {
        return gcmcService.add(gcmc);
    }

    @RequestMapping("update")
    @ResponseBody
    public boolean update(Gcmc gcmc) {
        return gcmcService.update(gcmc);
    }

    @PostMapping("delete")
    public boolean delete(@RequestParam("ids[]") int[] ids) {
        return gcmcService.delete(ids);
    }

    @RequestMapping("getGcmcs")
    public DataGridResult getGcmcs(@RequestParam(value = "gcmc_name", required = false, defaultValue = "") String gcmc_name,
                                   @RequestParam(value = "khmc_id", required = false, defaultValue = "0") Long khmc_id,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "rows", required = false, defaultValue = "10") int rows) {
        System.out.println(gcmc_name + ":" + khmc_id);
        PageHelper.startPage(page, rows);
        return PageUtils.convertToResult(gcmcService.getGcmcs(khmc_id, gcmc_name));
    }
}

package com.sys.demo01.controller;

import com.github.pagehelper.PageHelper;
import com.sys.demo01.pojo.DataGridResult;
import com.sys.demo01.pojo.Yclrk;
import com.sys.demo01.service.YclrkService;
import com.sys.demo01.tools.PageUtils;
import com.sys.demo01.vo.YclrkVo;
import javafx.scene.chart.Axis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("yclrk")
public class YclrkController {
    @Autowired
    private YclrkService yclrkService;

    @RequestMapping("getAll")
    public DataGridResult getAll(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                 @RequestParam(value = "rows", required = false, defaultValue = "10") int rows) {
        PageHelper.startPage(page, rows);
        return PageUtils.convertToResult(yclrkService.getAll());
    }

    @PostMapping("getYclrkVos")
    public DataGridResult getYclrkVos(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                      @RequestParam(value = "rows", required = false, defaultValue = "10") int rows) {
        PageHelper.startPage(page, rows);
        return PageUtils.convertToResult(yclrkService.getYclrkVos());
    }

    @RequestMapping("getYclrkVoList")
    public DataGridResult getYclrkVoList(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                         @RequestParam(value = "rows", required = false, defaultValue = "10") int rows) {
        PageHelper.startPage(page, rows);
        return PageUtils.convertToResult(yclrkService.getYclrkVoList());
    }

    @PostMapping("add")
    public boolean add(Yclrk yclrk) {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = formatter.format(date);
        yclrk.setYclrk_time(time);
        yclrk.setYclrk_shelves("否");
        return yclrkService.addYclrk(yclrk);
    }

    @PostMapping("update")
    public boolean update(Yclrk yclrk) {
        return yclrkService.updataYclrk(yclrk);
    }

    @PostMapping("delete")
    public boolean deleteYclrk(@RequestParam("ids[]") int[] ids) {
        System.out.println(ids);
        for (int i = 0; i < ids.length; i++) {
            System.out.println(ids[i]);
        }
        return yclrkService.deleteYclrk(ids);
    }

    @RequestMapping("getYclrk")
    public DataGridResult getYclrk(@RequestParam(value = "yclrk_name", required = false, defaultValue = "") String yclrk_name,
                                   @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                   @RequestParam(value = "rows", required = false, defaultValue = "10") int rows) {
        PageHelper.startPage(page, rows);

        return PageUtils.convertToResult(yclrkService.getYclrk(yclrk_name));

    }

}

package com.sys.demo01.controller;

import com.sys.demo01.service.imple.MainMenusServiceImpl;
import com.sys.demo01.vo.MainMenusVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MainMenusServiceImpl mainMenusServiceImpl;


    @RequestMapping("/{view}")
    public String html(@PathVariable("view") String view) {
        return view;
    }//其中view就是你要打开的视图哦

    @RequestMapping("index/getAll")
    @ResponseBody
    public List<MainMenusVo> getAll() {
        System.out.println("进来了");
        return mainMenusServiceImpl.getAll();
    }
}

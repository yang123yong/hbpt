package com.sys.demo01.vo;

import com.sys.demo01.pojo.MainMenus;
import com.sys.demo01.pojo.MainMenus2;
import lombok.Data;

import java.util.List;

@Data
public class MainMenusVo extends MainMenus {
    private List<MainMenus2> chidrens;
}

package com.sys.demo01.service.imple;

import com.sys.demo01.pojo.MainMenus;
import com.sys.demo01.pojo.MainMenus2;
import com.sys.demo01.vo.MainMenusVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainMenusServiceImpl {

    public List<MainMenusVo> getAll() {
        //模拟数据
        MainMenus2 mainMenus2 = new MainMenus2();
        mainMenus2.setMenuname("客户管理");
        mainMenus2.setIcon("icon-bullet_right");
        mainMenus2.setUrl("khmc.html");
        MainMenus2 mainMenus3 = new MainMenus2();
        mainMenus3.setMenuname("原材料入库");
        mainMenus3.setIcon("icon-bullet_right");
        mainMenus3.setUrl("yclrk.html");
        MainMenus2 mainMenus4 = new MainMenus2();
        mainMenus4.setMenuname("货架管理");
        mainMenus4.setIcon("icon-bullet_right");
        mainMenus4.setUrl("<a></a>");
        List<MainMenus2> mainMenus2s = new ArrayList<>();
        mainMenus2s.add(mainMenus2);
        mainMenus2s.add(mainMenus3);
        mainMenus2s.add(mainMenus4);
        MainMenusVo mainMenusVo = new MainMenusVo();
        mainMenusVo.setMenuid(1);
        mainMenusVo.setMenuname("客服管理");
        mainMenusVo.setIcon("icon-sys");
        mainMenusVo.setChidrens(mainMenus2s);

        MainMenusVo mainMenusVo2 = new MainMenusVo();
        mainMenusVo2.setMenuid(2);
        mainMenusVo2.setMenuname("账单管理");
        mainMenusVo2.setIcon("icon-sys");
        List<MainMenusVo> mainMenusVos = new ArrayList<>();
        mainMenusVos.add(mainMenusVo);
        mainMenusVos.add(mainMenusVo2);
        return mainMenusVos;
    }
}

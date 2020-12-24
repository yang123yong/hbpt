package com.sys.demo01.pojo;

import lombok.Data;

@Data
public class MainMenus2 {
    private String menuname;//二级菜单
    private String icon;//图标,
    private String url;//路径"

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

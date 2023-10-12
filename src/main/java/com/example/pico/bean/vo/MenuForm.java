package com.example.pico.bean.vo;

public class MenuForm {
    private String menuName;
    private String menuUrl;
    private String id;
    private String pid;
    private String ordered;
    private String icon;

    @Override
    public String toString() {
        return "AddForm{" +
                "menuName='" + menuName + '\'' +
                ", menuUrl='" + menuUrl + '\'' +
                ", id='" + id + '\'' +
                ", ordered='" + ordered + '\'' +
                ", icon='" + icon + '\'' +
                '}';
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrdered() {
        return ordered;
    }

    public void setOrdered(String ordered) {
        this.ordered = ordered;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}

package com.example.pico.bean.vo;

import java.util.List;

/**
 * 前端菜单树形结构
 */
public class MenuTree {

    private String label;
    private String id;
    private String pid;
    private Integer order;
    private String url;
    private List<MenuTree> children;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<MenuTree> getChildren() {
        return children;
    }

    public void setChildren(List<MenuTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MenuTree{" +
                "label='" + label + '\'' +
                ", id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", order=" + order +
                ", url='" + url + '\'' +
                ", children=" + children +
                '}';
    }
}

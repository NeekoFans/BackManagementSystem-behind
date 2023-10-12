package com.example.pico.bean.vo;

import java.util.List;

public class RoleTree {
    private String label;
    private String id;
    private String pid;

    private List<RoleTree> children;


    public List<RoleTree> getChildren() {
        return children;
    }

    public void setChildren(List<RoleTree> children) {
        this.children = children;
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


    @Override
    public String toString() {
        return "RoleTree{" +
                "label='" + label + '\'' +
                ", id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", children=" + children +
                '}';
    }
}

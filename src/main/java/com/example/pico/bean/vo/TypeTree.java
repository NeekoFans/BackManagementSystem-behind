package com.example.pico.bean.vo;

import java.util.List;

public class TypeTree {
    private String label;
    private String id;
    private String pid;
    private List<TypeTree> children;

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

    public List<TypeTree> getChildren() {
        return children;
    }

    public void setChildren(List<TypeTree> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "TypeTree{" +
                "label='" + label + '\'' +
                ", id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", children=" + children +
                '}';
    }
}

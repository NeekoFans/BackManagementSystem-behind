package com.example.pico.bean.vo;

import java.util.List;

/**
 * 前端菜单树形结构
 */
public class TreeNode {
    /**
     * 菜单名称
     */
    private Object label;
    private Object id;

    /**
     * 子菜单
     */
    private List<TreeNode> children;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getLabel() {
        return label;
    }

    public void setLabel(Object label) {
        this.label = label;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }
}

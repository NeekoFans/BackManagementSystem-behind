package com.example.pico.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class JxcRole {
    private String id;
    private String pid;
    private String name;
    private String flag;
    @JsonIgnore
    private Integer pageNo;
    @JsonIgnore
    private Integer pageSize;
    @JsonIgnore
    private Integer offset;
    private Long total;
    //@JsonIgnore
    private List<String> menuIdList;

    public List<String> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<String> menuIdList) {
        this.menuIdList = menuIdList;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getOffset() {
        return (pageNo-1)*pageSize;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "JxcRole{" +
                "id='" + id + '\'' +
                ", pid='" + pid + '\'' +
                ", name='" + name + '\'' +
                ", flag='" + flag + '\'' +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                ", total=" + total +
                ", menuIdList=" + menuIdList +
                '}';
    }
}

package com.example.pico.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class JxcType {
    private String id;
    private String name;
    private String pId;
    private String total;
    private Integer totalList;
    @JsonIgnore
    private Integer pageNo;
    @JsonIgnore
    private Integer pageSize;
    @JsonIgnore
    private Integer offset;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy年-MM月-dd日",timezone = "GMT+8")
    private LocalDate createTime;

    public Integer getTotalList() {
        return totalList;
    }

    public void setTotalList(Integer totalList) {
        this.totalList = totalList;
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

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "JxcType{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pId='" + pId + '\'' +
                ", total='" + total + '\'' +
                ", totalList=" + totalList +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                ", createTime=" + createTime +
                '}';
    }
}

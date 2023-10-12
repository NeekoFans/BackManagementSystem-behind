package com.example.pico.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.xml.ws.Service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class JxcProductOrder {
    private String id;
    private String typeId;
    private String name;
    private Integer number;
    private String price;
    private String creater;
    private String createrId;
    private Integer orderType;
    private String createDate;
    private String reason;
    private Integer status;
    private Integer total;
    @JsonIgnore
    private Integer pageNo;
    @JsonIgnore
    private Integer pageSize;
    @JsonIgnore
    private Integer offset;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCreater() {
        return creater;
    }

    public void setCreater(String creater) {
        this.creater = creater;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "JxcProductOrder{" +
                "id='" + id + '\'' +
                ", typeId='" + typeId + '\'' +
                ", name='" + name + '\'' +
                ", number=" + number +
                ", price='" + price + '\'' +
                ", creater='" + creater + '\'' +
                ", createrId='" + createrId + '\'' +
                ", orderType=" + orderType +
                ", createDate='" + createDate + '\'' +
                ", reason='" + reason + '\'' +
                ", status=" + status +
                ", total=" + total +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", offset=" + offset +
                '}';
    }
}

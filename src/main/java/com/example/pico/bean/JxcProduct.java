package com.example.pico.bean;

import javax.xml.ws.Service;

public class JxcProduct {
    private String id;
    private String typeId;
    private Integer total;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "JxcProduct{" +
                "id='" + id + '\'' +
                ", typeId='" + typeId + '\'' +
                ", total=" + total +
                '}';
    }
}

package com.example.pico.dao;

import com.example.pico.bean.JxcProductOrder;
import com.example.pico.bean.JxcType;
import com.example.pico.bean.vo.MenuTree;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JxcProductOrderDaoI {

    Integer getAddTotal(JxcProductOrder jxcProductOrder);
    Integer total(JxcProductOrder jxcProductOrder);
    List<JxcProductOrder>  getOrderList(JxcProductOrder jxcProductOrder);
    Integer reviewTotal(JxcProductOrder jxcProductOrder);
}

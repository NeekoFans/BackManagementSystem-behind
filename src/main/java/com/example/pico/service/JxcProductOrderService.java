package com.example.pico.service;

import com.example.pico.bean.JxcProduct;
import com.example.pico.bean.JxcProductOrder;
import com.example.pico.bean.JxcRole;
import com.example.pico.dao.JxcProductOrderDao;
import com.example.pico.dao.JxcProductOrderDaoI;
import com.example.pico.service.Imp.JxcProductOrderServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JxcProductOrderService {
    @Resource
    private JxcProductOrderDao jxcOrderDao;
    @Resource
    private JxcProductOrderDaoI jxcOrderDaoI;

    public List<JxcProductOrder> getOrderList(JxcProductOrder jxcProductOrder) {
        List<JxcProductOrder> jxcOrderList=jxcOrderDao.getOrderList(jxcProductOrder);
        if (jxcOrderList.size()!=0){
            jxcOrderList.get(0).setTotal(jxcOrderDaoI.total(jxcProductOrder));
        }

        return jxcOrderList;
    }
    public List<JxcProductOrder> getAddList(JxcProductOrder jxcProductOrder) {
        List<JxcProductOrder> jxcOrderList=jxcOrderDao.getAddList(jxcProductOrder);

        if (jxcOrderList.size()!=0){
            jxcOrderList.get(0).setTotal(jxcOrderDaoI.getAddTotal(jxcProductOrder));
        }

        return jxcOrderList;
    }

//    public List<Integer> total() {
//        Integer total=jxcOrderDaoI.total();
//        List<Integer> list=new ArrayList<>();
//        list.add(total);
//        return list;
//
//    }
//    public List<Integer> getAddTotal() {
//        Integer total=jxcOrderDaoI.getAddTotal();
//        List<Integer> list=new ArrayList<>();
//        list.add(total);
//        return list;
//
//    }

    public void delete(String id) {
        jxcOrderDao.delete(id);
    }

    public List<JxcProductOrder> getById(Long id) {
        return jxcOrderDao.getById(id);

    }

    public void update(JxcProductOrder jxcRole) {
        jxcOrderDao.update(jxcRole);
    }

    public List<JxcProductOrder> reviewList(JxcProductOrder jxcProductOrder) {
        List<JxcProductOrder> jxcProductOrders=jxcOrderDao.reviewList(jxcProductOrder);
        if (jxcProductOrders.size()!=0){
            jxcProductOrders.get(0).setTotal(jxcOrderDaoI.reviewTotal(jxcProductOrder));
        }

        return jxcProductOrders;

    }

    public void editBytypeId(String typeId) {
        jxcOrderDao.editBytypeId(typeId);
    }

    public void deleteBytypeId(String typeId) {
        jxcOrderDao.deleteBytypeId(typeId);
    }

    public void refuseBytypeId(String typeId) {
        jxcOrderDao.refuseBytypeId(typeId);
    }

    public void editOutBytypeId(String typeId) {
        jxcOrderDao.editOutBytypeId(typeId);
    }

    public void endByTypeId(String typeId,String orderType,String reason) {
        jxcOrderDao.endByTypeId(typeId,orderType,reason);
    }

    public void reason(String reason,String typeId,String orderType) {
        jxcOrderDao.reason(reason,typeId,orderType);

    }

//    public List<Integer> reviewTotal(Integer orderType) {
//        Integer total=jxcOrderDaoI.reviewTotal(jxcProductOrder);
//        List<Integer> list=new ArrayList<>();
//        list.add(total);
//        return list;
//
//    }
}

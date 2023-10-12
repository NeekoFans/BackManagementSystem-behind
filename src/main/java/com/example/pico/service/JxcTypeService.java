package com.example.pico.service;

import com.example.pico.bean.JxcProductOrder;
import com.example.pico.bean.JxcRole;
import com.example.pico.bean.JxcType;
import com.example.pico.bean.vo.MenuForm;
import com.example.pico.bean.vo.MenuTree;
import com.example.pico.dao.JxcTypeDao;
import com.example.pico.dao.JxcTypeDaoI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class JxcTypeService {
    @Resource
    JxcTypeDao jxcTypeDao;
    @Resource
    JxcTypeDaoI jxcTypeDaoI;
    public void add(MenuForm menuForm) {
        jxcTypeDao.add(menuForm);
    }

    public void getFormData(MenuForm menuForm) {
        jxcTypeDao.update(menuForm);
    }

    public List<MenuTree> queryPid(String id) {
        List<MenuTree>list= jxcTypeDaoI.queryPid(id);
        return list;
    }

    public void delete(String id) {
        jxcTypeDao.delete(id);
    }

    public List<JxcType> getTypeList(JxcType jxcType) {
        List<JxcType> jxcTypeList=jxcTypeDao.getTypeList(jxcType);
        if (jxcTypeList.size()!=0){
            jxcTypeList.get(0).setTotalList(jxcTypeDaoI.total(jxcType));
        }

        return jxcTypeList;
    }

//    public List<Integer> total() {
//        Integer total=jxcTypeDaoI.total();
//        List<Integer> list=new ArrayList<>();
//        list.add(total);
//        return list;
//
//    }

    public List<Map<String, Object>> hasChild(String id) {
        List<Map<String, Object>> typeList=jxcTypeDao.hasChild(id);
        return typeList;

    }

    public void addForm(JxcProductOrder jxcProductOrder) {
        jxcProductOrder.setOrderType(1);
        jxcProductOrder.setStatus(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date createTime = new Date();
        jxcProductOrder.setCreateDate(simpleDateFormat.format(createTime));
        jxcTypeDao.addForm(jxcProductOrder);
    }

    public void sellForm(JxcProductOrder jxcProductOrder) {
        jxcProductOrder.setOrderType(2);
        jxcProductOrder.setStatus(1);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date createTime = new Date();
        jxcProductOrder.setCreateDate(simpleDateFormat.format(createTime));
        jxcTypeDao.sellForm(jxcProductOrder);
    }
}

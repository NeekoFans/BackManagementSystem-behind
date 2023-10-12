package com.example.pico.service;

import com.example.pico.bean.JxcProduct;
import com.example.pico.bean.JxcRole;
import com.example.pico.bean.vo.Result;
import com.example.pico.dao.JxcProductDao;
import com.example.pico.service.Imp.JxcProductServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JxcProductService {
    @Resource
    private JxcProductDao jxcProductDao;


    public List<JxcProduct> selectByTypeId(String typeId) {

        return jxcProductDao.selectByTypeId(typeId);
    }

    public void addTotal(Integer total,String typeId) {
        List<JxcProduct> jxcProductList=jxcProductDao.selectByTypeId(typeId);
       Integer Stotal= jxcProductList.get(0).getTotal();
       total=total+Stotal;
       jxcProductDao.updateTotal(total,typeId);

    }

    public void addProduct(Integer total, String typeId) {
        jxcProductDao.addProduct(total,typeId);
    }

    public Integer differenceByTotal(Integer total, String typeId) {
        List<JxcProduct> jxcProductList=jxcProductDao.selectByTypeId(typeId);
        Integer Stotal= jxcProductList.get(0).getTotal();
        Integer Ntotal=Stotal-total;
         return Ntotal;
    }

    public void deleteBytypeId(String typeId) {
        jxcProductDao.deleteBytypeId(typeId);
    }

    public void deleteTotal(Integer total, String typeId) {
        List<JxcProduct> jxcProductList=jxcProductDao.selectByTypeId(typeId);
        Integer Stotal= jxcProductList.get(0).getTotal();
        total=Stotal-total;
        jxcProductDao.updateTotal(total,typeId);
    }
}

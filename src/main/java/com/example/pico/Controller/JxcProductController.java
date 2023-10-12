package com.example.pico.Controller;

import com.example.pico.bean.JxcProduct;
import com.example.pico.bean.JxcRole;
import com.example.pico.bean.vo.Result;
import com.example.pico.service.JxcProductService;
import com.example.pico.service.JxcRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/product")
public class JxcProductController {
    @Resource
    private JxcProductService jxcProductService;
    @RequestMapping("/selectByTypeId")
    public Result<List<JxcProduct>> selectByTypeId(String typeId){
        List<JxcProduct> jxcProduct=jxcProductService.selectByTypeId(typeId);
        return Result.success(jxcProduct);
    }
    @RequestMapping("/addTotal")
    public Result<List<JxcProduct>> addTotal(Integer total,String typeId){
        jxcProductService.addTotal(total,typeId);
        return Result.success("新增数量成功");
    }
    @RequestMapping("/deleteTotal")
    public Result<List<JxcProduct>> deleteTotal(Integer total,String typeId){
        jxcProductService.deleteTotal(total,typeId);
        return Result.success("减少数量成功");
    }
    @RequestMapping("/differenceByTotal")
    public Result<List<JxcProduct>> differenceByTotal(Integer total,String typeId){
      Integer result=jxcProductService.differenceByTotal(total,typeId);
        return Result.success(result);
    }
    @RequestMapping("/addProduct")
    public Result<List<JxcProduct>> addProduct(Integer total,String typeId){
        jxcProductService.addProduct(total,typeId);
        return Result.success("新增产品成功");
    }
    @RequestMapping("/deleteBytypeId")
    public Result<List<JxcProduct>> deleteBytypeId(String typeId){
        jxcProductService.deleteBytypeId(typeId);
        return Result.success("删除产品成功");
    }
}

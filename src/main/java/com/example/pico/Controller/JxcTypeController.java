package com.example.pico.Controller;

import com.example.pico.bean.JxcProductOrder;
import com.example.pico.bean.JxcRole;
import com.example.pico.bean.JxcType;
import com.example.pico.bean.vo.MenuForm;
import com.example.pico.bean.vo.MenuTree;
import com.example.pico.bean.vo.Result;
import com.example.pico.service.JxcTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/type")
public class JxcTypeController {
    @Resource
    JxcTypeService jxcTypeService;

    @RequestMapping("/list")
    public Result<List<JxcType>> getTypeList(JxcType jxcType){
        List<JxcType> typeList=jxcTypeService.getTypeList(jxcType);
        return Result.success(typeList);
    }
//    @RequestMapping("/getTotal")
//    public Result<List<Integer>> total(){
//        List<Integer> total=jxcTypeService.total();
//        return Result.success(total);
//    }
    @RequestMapping("/addTypeHandle")
    public Result<MenuForm> add(MenuForm menuForm){
        jxcTypeService.add(menuForm);
        return Result.success("新增成功");
    }
    @RequestMapping("/editTypeBrand")
    public Result<List<MenuForm>>  getFormData(MenuForm menuForm){
        jxcTypeService.getFormData(menuForm);
        List<MenuForm> list=new ArrayList<>();
        return Result.success(list);
    }
    @RequestMapping("/queryTypePid")
    public Result<MenuForm> queryPid(String id){
        List<MenuTree> list= jxcTypeService.queryPid(id);
        return Result.success(list);
    }
    @RequestMapping("/delTypeHandle")
    public Result<MenuForm> delete(String id){
        jxcTypeService.delete(id);
        return Result.success("删除成功");
    }
    @RequestMapping("/hasChild")
    public Result<List<Map<String, Object>>> hasChild(String id){
        List<Map<String, Object>> typeList=jxcTypeService.hasChild(id);

        return Result.success(typeList);
    }
    @RequestMapping("/addForm")
    public Result<JxcProductOrder> addForm(JxcProductOrder jxcProductOrder){
        jxcTypeService.addForm(jxcProductOrder);
        return Result.success("添加入库");
    }

    @RequestMapping("/sellForm")
    public Result<JxcProductOrder> sellForm(JxcProductOrder jxcProductOrder){
        jxcTypeService.sellForm(jxcProductOrder);
        return Result.success("添加出库");
    }
}

package com.example.pico.Controller;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.vo.MenuForm;
import com.example.pico.bean.vo.MenuTree;
import com.example.pico.bean.vo.Result;
import com.example.pico.bean.vo.TreeNode;
import com.example.pico.service.JxcMenuService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;


@RestController
public class JxcMenuController {
    @Resource
    private JxcMenuService jxcMenuService;
        @RequestMapping("/query")
    public Result<List<MenuTree>> query(){
        List<MenuTree> result=jxcMenuService.query();

        return Result.success(result);
    }
    @RequestMapping("/queryType")
    public Result<List<MenuTree>> queryByAccount(String account){
        List<MenuTree> result=jxcMenuService.queryByAccount(account);

        return Result.success(result);
    }
    @RequestMapping("/getJxcMenu")
    public Result<List<TreeNode>>  get(){
        List<TreeNode> result =jxcMenuService.get();
        return Result.success(result);
    }
    @RequestMapping("/addDevHandle")
    public Result<MenuForm> add(MenuForm menuForm){
        jxcMenuService.add(menuForm);
        return Result.success("新增成功");
    }
    @RequestMapping("/editBrand")
    public Result<List<MenuForm>>  getFormData(MenuForm menuForm){
        jxcMenuService.getFormData(menuForm);
        List<MenuForm> list=new ArrayList<>();
        return Result.success(list);
    }
    @RequestMapping("/queryPid")
    public Result<MenuForm> queryPid(String id){
        List<MenuTree> list= jxcMenuService.queryPid(id);
        return Result.success(list);
    }
    @RequestMapping("/delDevHandle")
    public Result<MenuForm> delete(String id){
       jxcMenuService.delete(id);
       return Result.success("删除成功");
    }
}

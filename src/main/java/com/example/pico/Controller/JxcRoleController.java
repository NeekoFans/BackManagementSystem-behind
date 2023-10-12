package com.example.pico.Controller;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.JxcRole;
import com.example.pico.bean.vo.Result;
import com.example.pico.service.JxcMenuService;
import com.example.pico.service.JxcRoleService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role")
public class JxcRoleController {
    @Resource
    private JxcRoleService jxcRoleService;


    @RequestMapping("/list")
    public Result<List<JxcRole>> getRoleList(JxcRole jxcRole){
        List<JxcRole> roleList=jxcRoleService.getRoleList(jxcRole);

        return Result.success(roleList);
    }
//    @RequestMapping("/getTotal")
//    public Result<List<Integer>> total(){
//        List<Integer> total=jxcRoleService.total();
//        return Result.success(total);
//    }

   @RequestMapping("/addRole")
    public Result addRole(JxcRole jxcRole){
        jxcRoleService.addRole(jxcRole);
        return Result.success("新增成功");
   }
    @RequestMapping("/getById")
    public Result<List<JxcRole>> getById(Long id){
        List<JxcRole> list= jxcRoleService.getById(id);

        return Result.success(list.get(0));
    }

    @RequestMapping("/update")
    public Result update(JxcRole jxcRole){
        jxcRoleService.update(jxcRole);
        return Result.success("修改成功");
    }

    @RequestMapping("/delete")
    public Result delete(String id){
        jxcRoleService.delete(id);
        return Result.success("删除成功");
    }
}

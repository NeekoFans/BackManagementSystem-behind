package com.example.pico.Controller;

import com.example.pico.bean.User;
import com.example.pico.bean.vo.Result;
import com.example.pico.bean.vo.RoleTree;
import com.example.pico.config.RedisUtil;
import com.example.pico.service.JxcUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private JxcUserService jxcUserService;

    @Resource
    private RedisUtil redisUtil;
    @RequestMapping("/list")
    public Result<List<User>> getUserList(User user) throws JsonProcessingException {
//        JsonMapper jsonMapper=new JsonMapper();
//        String key="getList---"+jsonMapper.writeValueAsString(user);
//        if (redisUtil.hasKey(key)){
////            System.out.println("====存在缓存数据====");
//            return redisUtil.get(key);
//        }
////        System.out.println("====没有缓存数据，查询数据库====");
        List<User> userList=jxcUserService.getUserList(user);
//        redisUtil.set(key,userList,3);
        return Result.success(userList);
    }
    @RequestMapping("/roleList")
    public Result<List<RoleTree>> query(){
        List<RoleTree> result=jxcUserService.query();

        return Result.success(result);
    }
//    @RequestMapping("/getTotal")
//    public Result<List<Integer>> total(){
//        List<Integer> total=jxcUserService.total();
//        return Result.success(total);
//    }

   @RequestMapping("/addUser")
    public Result addUser(User user){
        jxcUserService.addUser(user);
        return Result.success("新增成功");
   }
    @RequestMapping("/getById")
    public Result<List<User>> getById(Long id){
        List<User> list= jxcUserService.getById(id);

        return Result.success(list.get(0));
    }

    @RequestMapping("/update")
    public Result update(User user){
        jxcUserService.update(user);
        return Result.success("修改成功");
    }

    @RequestMapping("/delete")
    public Result delete(String id){
        jxcUserService.delete(id);
        return Result.success("删除成功");
    }
}

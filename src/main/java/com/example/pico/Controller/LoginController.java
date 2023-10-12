package com.example.pico.Controller;

import com.example.pico.bean.vo.MenuTree;
import com.example.pico.bean.vo.Result;
import com.example.pico.service.LoginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class LoginController {
    @Resource
    private LoginService loginService;
    @RequestMapping("/login")
    public Map login(String account,String password,String photo){
        Map map=loginService.login(account,password,photo);
        return map;
    }

    @RequestMapping("/queryByUserId")
    public Result<List<MenuTree>> query(String account) {
        List<MenuTree> result = loginService.query(account);

        return Result.success(result);
    }
}

package com.example.pico.Controller;

import com.example.pico.bean.JxcRole;
import com.example.pico.bean.JxcRoleUser;
import com.example.pico.service.JxcRoleUserService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@Transactional
@RestController
@Controller
public class JxcRoleUserController {
    @Resource
    private JxcRoleUserService jxcRoleUserService;
    @RequestMapping("/getJxcRoleUser")
    public Map get(JxcRoleUser jxcRoleUser, String id){
        Map map=jxcRoleUserService.get(jxcRoleUser,id);
        return map;
    }
}

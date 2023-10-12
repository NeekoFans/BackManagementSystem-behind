package com.example.pico.Controller;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.JxcMenuRole;
import com.example.pico.service.JxcMenuRoleService;
import com.example.pico.service.JxcMenuService;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@Transactional
@RestController
@Controller
public class JxcMenuRoleController {
    @Resource
    private JxcMenuRoleService jxcMenuRoleService;
    @RequestMapping("/getJxcMenuRole")
    public Map get(JxcMenuRole JxcMenuRole, String id){
        Map map=jxcMenuRoleService.get(JxcMenuRole,id);
        return map;
    }
}

package com.example.pico.service;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.JxcMenuRole;
import com.example.pico.dao.JxcMenurRoleDao;
import com.example.pico.service.Imp.JxcMenuRoleServiceI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JxcMenuRoleService implements JxcMenuRoleServiceI {
    @Resource
    private JxcMenurRoleDao jxcMenurRoleDao;
    @Override
    public Map get(JxcMenuRole jxcMenuRole, String id) {
        Map map=new HashMap();
        List<JxcMenuRole> list=jxcMenurRoleDao.getList(jxcMenuRole,id);
        map.put("code",1);
        map.put("row",list);
        return map;
    }
}

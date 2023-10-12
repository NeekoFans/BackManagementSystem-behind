package com.example.pico.service;

import com.example.pico.bean.JxcRole;
import com.example.pico.bean.JxcRoleUser;
import com.example.pico.dao.JxcRoleUserDao;
import com.example.pico.service.Imp.JxcRoleUserI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class JxcRoleUserService implements JxcRoleUserI {
    @Resource
    private JxcRoleUserDao jxcRoleUserDao;
    @Override
    public Map get(JxcRoleUser jxcRoleUser, String id) {
        Map map=new HashMap();
        List<JxcRoleUser> list=jxcRoleUserDao.getList(jxcRoleUser,id);
        map.put("code",1);
        map.put("row",list);
        return map;
    }
}

package com.example.pico.service.Imp;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.JxcRole;

import java.util.List;
import java.util.Map;

public interface JxcRoleServiceI {
    public Map get(JxcRole jxcRole, String id);
    List<JxcRole> getRoleList();
    List<Long> total();
}

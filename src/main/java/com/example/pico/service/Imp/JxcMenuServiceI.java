package com.example.pico.service.Imp;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.vo.MenuForm;
import com.example.pico.bean.vo.TreeNode;

import java.util.List;
import java.util.Map;

public interface JxcMenuServiceI {
    List<TreeNode> get(JxcMenu jxcMenu, String id);
    Map edit(JxcMenu jxcMenu);
    Map add(MenuForm menuForm);
    Map delete(String id);
}

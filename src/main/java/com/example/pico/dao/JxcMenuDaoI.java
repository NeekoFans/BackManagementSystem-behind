package com.example.pico.dao;

import com.example.pico.bean.vo.MenuTree;
import com.example.pico.bean.vo.TreeNode;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JxcMenuDaoI {
    List<MenuTree> query();
    List<MenuTree> queryByAccount(String account);

    List<MenuTree>queryPid(String id);
}

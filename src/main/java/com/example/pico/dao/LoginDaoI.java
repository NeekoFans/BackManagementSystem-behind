package com.example.pico.dao;

import com.example.pico.bean.vo.MenuTree;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDaoI {
    List<MenuTree> query(String account);
}

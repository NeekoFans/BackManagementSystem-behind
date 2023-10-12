package com.example.pico.dao;

import com.example.pico.bean.JxcRole;
import com.example.pico.bean.User;
import com.example.pico.bean.vo.MenuTree;
import com.example.pico.bean.vo.RoleTree;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JxcUserDaoI {
     List<User> getUserList(User user);
     List<RoleTree> query();
     Long total(User user);

     List<User> getById(String id);

     void delete(String id);
}

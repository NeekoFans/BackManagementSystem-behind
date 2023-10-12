package com.example.pico.dao;

import com.example.pico.bean.JxcMenuRole;
import com.example.pico.bean.JxcRoleUser;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JxcRoleUserDaoI {

    List<JxcRoleUser> getById(Long id);

}

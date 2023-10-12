package com.example.pico.dao;

import com.example.pico.bean.JxcRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JxcRoleDaoI {
     List<JxcRole> getRoleList(JxcRole jxcRole);
     Long total(JxcRole jxcRole);

     List<JxcRole> getById(String id);

     void delete(String id);
}

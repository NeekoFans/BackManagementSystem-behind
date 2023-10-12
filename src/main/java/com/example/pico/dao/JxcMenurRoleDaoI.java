package com.example.pico.dao;

import com.example.pico.bean.JxcMenuRole;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JxcMenurRoleDaoI {

    List<JxcMenuRole> getById(Long id);

}

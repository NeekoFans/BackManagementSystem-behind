package com.example.pico.dao;

import com.example.pico.bean.JxcType;
import com.example.pico.bean.vo.MenuTree;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JxcTypeDaoI {

    List<MenuTree> queryPid(String id);

    List<JxcType> getTypeList(JxcType jxcType);

    Integer total(JxcType jxcType);
}

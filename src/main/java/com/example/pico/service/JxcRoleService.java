package com.example.pico.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.example.pico.bean.JxcMenuRole;
import com.example.pico.bean.JxcRole;
import com.example.pico.dao.JxcMenurRoleDao;
import com.example.pico.dao.JxcMenurRoleDaoI;
import com.example.pico.dao.JxcRoleDao;
import com.example.pico.dao.JxcRoleDaoI;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service

public class JxcRoleService  {
    @Resource
    private JxcRoleDao jxcRoleDao;
    @Resource
    private JxcRoleDaoI jxcRoleDaoI;
    @Resource
    private JxcMenurRoleDao jxcMenurRoleDao;
    @Resource
    private JxcMenurRoleDaoI jxcMenurRoleDaoI;
//    @Resource
//    private SnowflakeIdWorker snowflakeIdWorker;
    public List<JxcRole> getRoleList(JxcRole jxcRole) {
        List<JxcRole> roleList=jxcRoleDaoI.getRoleList(jxcRole);
         roleList.get(0).setTotal(jxcRoleDaoI.total(jxcRole));
        return roleList;
    }


//    public List<Integer> total() {
//        Integer total=jxcRoleDaoI.total();
//        List<Integer> list=new ArrayList<>();
//        list.add(total);
//        return list;
//    }

    public void addRole(JxcRole jxcRole) {
        //JxcRole jxcRole1=jxcRole;
        //@JsonSerialize(using = ToStringSerializer.class)
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);

        long id = snowflake.nextId();
        //数据库设置自增没影响，没有传入id就自增，传入了用传入的
        //雪花算法生成的是long型的，需要转为JSON给前端的js对象接收，强行传递会存在数据丢失的问题，
        // 所以需要在传递给前端之前做一类型转换来解决数据丢失问题
        String str = String.valueOf(id);
        jxcRole.setId(str);
        jxcRole.setPid("0");
        jxcRoleDao.addRole(jxcRole);

        jxcMenurRoleDao.addMenuRole(jxcRole);


    }

    public List<JxcRole> getById(Long id) {
        List<JxcRole>list= jxcRoleDao.getById(id);

        List<JxcMenuRole>list1=jxcMenurRoleDao.getById(id);
        List<String>integerList=new ArrayList<>();
        for (JxcMenuRole jxcMenuRole : list1) {
           integerList.add(jxcMenuRole.getMenuId());
        }

       list.get(0).setMenuIdList(integerList);
        return list;
    }

    public void update(JxcRole jxcRole) {
        jxcRoleDao.update(jxcRole);
        jxcMenurRoleDao.delete(jxcRole);
        jxcMenurRoleDao.addMenuRole(jxcRole);
    }

    public void delete(String id) {
        jxcRoleDao.delete(id);
        jxcMenurRoleDao.delete1(id);
    }
}

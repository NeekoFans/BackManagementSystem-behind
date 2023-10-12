package com.example.pico.service;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import com.example.pico.bean.JxcMenuRole;
import com.example.pico.bean.JxcRole;
import com.example.pico.bean.JxcRoleUser;
import com.example.pico.bean.User;
import com.example.pico.bean.vo.MenuTree;
import com.example.pico.bean.vo.RoleTree;
import com.example.pico.dao.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service

public class JxcUserService {
    @Resource
    private JxcUserDao jxcUserDao;
    @Resource
    private JxcUserDaoI jxcUserDaoI;
    @Resource
    private JxcRoleUserDao jxcRoleUserDao;
    @Resource
    private JxcRoleUserDaoI jxcRoleUserDaoI;
//    @Resource
//    private SnowflakeIdWorker snowflakeIdWorker;
    public List<User> getUserList(User user) {
        //这里如果按注释的写就会报错找不到包。
        List<User> userList=jxcUserDaoI.getUserList(user);
//        jxcUserDaoI.total(user);
        userList.get(0).setTotal(jxcUserDaoI.total(user));

        return userList;


    }
    public List<RoleTree> query(){
        List<RoleTree> allList=jxcUserDao.query();
        //查找所有的跟节点
        List<RoleTree> rootList=new ArrayList<>();
        for (int i = 0; i <allList.size() ; i++) {
            if (allList.get(i).getPid().equals("0")){
                rootList.add(allList.get(i));

            }
        }
        //查找根节点下的子类
        for (RoleTree treeNode:rootList){
            List<RoleTree>children=getChild(treeNode.getId(),allList);
            //对子节点进行排序

            treeNode.setChildren(children);
        }
        //对根节点进行排序


        return rootList;
    }
    private List<RoleTree> getChild(String id, List<RoleTree> allList){
        List<RoleTree> children=new ArrayList<>();
        for (int i = 0; i <allList.size() ; i++) {
            if (allList.get(i).getPid().equals(id)){
                children.add(allList.get(i));
            }
        }
//        for (MenuTree treeNode:allList){
//            if (treeNode.getPid().equals(id)){
//                children.add(treeNode);
//            }
//        }
        //递归调用子节点，可以无限追加子节点
        for (RoleTree menuTree:children){
            List<RoleTree> menuTreeChildren=getChild(menuTree.getId(),allList);
            menuTree.setChildren(menuTreeChildren);
        }
        if (children==null){
            return null;
        }

        return children;
    }

//    public List<Integer> total() {
//        Integer total=jxcUserDaoI.total();
//        List<Integer> list=new ArrayList<>();
//        list.add(total);
//        return list;
//    }

    public void addUser(User user) {
        //JxcRole jxcRole1=jxcRole;
        //@JsonSerialize(using = ToStringSerializer.class)
        Snowflake snowflake = IdUtil.createSnowflake(1, 1);

        long id = snowflake.nextId();
        //数据库设置自增没影响，没有传入id就自增，传入了用传入的
        //雪花算法生成的是long型的，需要转为JSON给前端的js对象接收，强行传递会存在数据丢失的问题，
        // 所以需要在传递给前端之前做一类型转换来解决数据丢失问题
        String str = String.valueOf(id);
        user.setId(str);
        user.setPassword("123456");

        jxcUserDao.addUser(user);

        jxcRoleUserDao.addRoleUser(user);


    }

    public List<User> getById(Long id) {
        List<User>list= jxcUserDao.getById(id);

        List<JxcRoleUser>list1=jxcRoleUserDao.getById(id);
        List<String>integerList=new ArrayList<>();
        for (JxcRoleUser jxcRoleUser : list1) {
           integerList.add(jxcRoleUser.getRoleId());
        }

       list.get(0).setRoleIdList(integerList);
        return list;
    }

    public void update(User user) {
        jxcUserDao.update(user);
        jxcRoleUserDao.delete(user);
        jxcRoleUserDao.addRoleUser(user);
    }

    public void delete(String id) {
        jxcUserDao.delete(id);
        jxcRoleUserDao.delete1(id);
    }
}

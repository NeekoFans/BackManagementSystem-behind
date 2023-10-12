package com.example.pico.service;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.JxcMenuRole;
import com.example.pico.bean.User;
import com.example.pico.bean.vo.MenuTree;
import com.example.pico.dao.LoginDao;
import com.example.pico.dao.LoginDaoI;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.*;

@Service
public class LoginService {
    @Resource
    private LoginDao loginDao;
    @Resource
    private LoginDaoI loginDaoI;
    public Map login(String account, String password, String photo) {
        Map map=new HashMap();
        User user=loginDao.getAccount(account);

        List<JxcMenu> list1=loginDao.getMenuList(account);
        List<String>integerList=new ArrayList<>();
        for (JxcMenu jxcMenuRole : list1) {
            integerList.add(jxcMenuRole.getText());
        }
        user.setMenuList(integerList);
            if (user==null){
                map.put("code",0);
                map.put("msg","账户名或密码错误111");
                return map;
            }
            if (!user.getPassword().equals(password)){
                map.put("code",0);
                map.put("msg","账户名或密码错误");
                return map;
            }
            map.put("登录成功呢","好耶");
            map.put("code",200);
            map.put("account",user.getAccount());
            map.put("菜单列表",user.getMenuList());
        return map;
    }

    public List<MenuTree> query(String account){
        List<MenuTree> allList=loginDaoI.query(account);
        //查找所有的跟节点
        List<MenuTree> rootList=new ArrayList<>();
        for (int i = 0; i <allList.size() ; i++) {
            if (allList.get(i).getPid().equals("0")){
                rootList.add(allList.get(i));

            }
        }
//两种for循环都能实现
//        for (MenuTree treeNode:allList) {
//            //数据库中的pid不能为null,否则会报错空指针异常
//            if (treeNode.getPid().equals("0")){
//                rootList.add(treeNode);
//
//            }
//
//        }

        //查找根节点下的子类
        for (MenuTree treeNode:rootList){
            List<MenuTree>children=getChild(treeNode.getId(),allList);
            //对子节点进行排序
            Collections.sort(children, new Comparator<MenuTree>() {
                @Override
                public int compare(MenuTree o1, MenuTree o2) {
                    return o1.getOrder()-o2.getOrder();
                }
            });
            treeNode.setChildren(children);
        }
        //对根节点进行排序
        Collections.sort(rootList, new Comparator<MenuTree>() {
            @Override
            public int compare(MenuTree o1, MenuTree o2) {
                return o1.getOrder()-o2.getOrder();
            }
        });

        return rootList;
    }
    private List<MenuTree> getChild(String id,List<MenuTree> allList){
        List<MenuTree> children=new ArrayList<>();
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
        for (MenuTree menuTree:children){
            List<MenuTree> menuTreeChildren=getChild(menuTree.getId(),allList);
            menuTree.setChildren(menuTreeChildren);
        }
        if (children==null){
            return null;
        }

        return children;
    }
}

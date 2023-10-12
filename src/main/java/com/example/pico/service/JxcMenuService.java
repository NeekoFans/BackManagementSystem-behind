package com.example.pico.service;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.vo.MenuForm;
import com.example.pico.bean.vo.MenuTree;
import com.example.pico.bean.vo.TreeNode;
import com.example.pico.dao.JxcMenuDao;
import com.example.pico.dao.JxcMenuDaoI;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service
public class JxcMenuService  {
    @Resource
    private JxcMenuDao jxcMenuDao;

    @Resource
    private JxcMenuDaoI jxcMenuDaoI;
    public List<MenuTree> query(){
        List<MenuTree> allList=jxcMenuDaoI.query();
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
    public List<MenuTree> queryByAccount(String account){
        List<MenuTree> allList=jxcMenuDaoI.queryByAccount(account);
        //查找所有的跟节点
        List<MenuTree> rootList=new ArrayList<>();
        for (int i = 0; i <allList.size() ; i++) {
            if (allList.get(i).getPid().equals("0")){
                rootList.add(allList.get(i));

            }
        }

        //查找根节点下的子类
        for (MenuTree treeNode:rootList){
            List<MenuTree>children=getChild(treeNode.getId(),allList);

            treeNode.setChildren(children);
        }


        return rootList;
    }
    //查找子节点的方法
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
    //手动写入节点数据
    public List<TreeNode> get() {
        List<Map<String,Object>> getList=jxcMenuDao.result();
    //设置根节点
        List<TreeNode> list=new ArrayList<>();
        //设置第一个根节点
        TreeNode rootNode1=new TreeNode();
        rootNode1.setLabel(getList.get(0).get("text_"));
        rootNode1.setId(getList.get(0).get("id_"));
            //设置子节点
            List<TreeNode> children1=new ArrayList<>();
                //设置第一个子节点
            TreeNode childNode1=new TreeNode();
            childNode1.setLabel(getList.get(1).get("text_"));
            childNode1.setId(getList.get(1).get("id_"));
               //设置第二个子节点
            TreeNode childNode2=new TreeNode();
            childNode2.setLabel(getList.get(2).get("text_"));
            childNode2.setId(getList.get(2).get("id_"));
               //设置第三个子节点
            TreeNode childNode3=new TreeNode();
            childNode3.setLabel(getList.get(3).get("text_"));
            childNode3.setId(getList.get(3).get("id_"));
              //设置第四个子节点
            TreeNode childNode4=new TreeNode();
            childNode4.setLabel(getList.get(4).get("text_"));
            childNode4.setId(getList.get(4).get("id_"));
         //设置第二个根节点
        TreeNode rootNode2=new TreeNode();
        rootNode2.setLabel(getList.get(5).get("text_"));
        rootNode2.setId(getList.get(5).get("id_"));
            //设置子节点
            List<TreeNode>children2=new ArrayList<>();
               //设置第一个子节点
               TreeNode childNode5=new TreeNode();
               childNode5.setLabel(getList.get(6).get("text_"));
               childNode5.setId(getList.get(6).get("id_"));
               //设置第二个子节点
               TreeNode childNode6=new TreeNode();
               childNode6.setLabel(getList.get(7).get("text_"));
               childNode6.setId(getList.get(7).get("id_"));
               //设置第三个子节点
               TreeNode childNode7=new TreeNode();
               childNode7.setLabel(getList.get(8).get("text_"));
               childNode7.setId(getList.get(8).get("id_"));
               //设置第四个子节点
               TreeNode childNode8=new TreeNode();
               childNode8.setLabel(getList.get(9).get("text_"));
               childNode8.setId(getList.get(9).get("id_"));



        //将子节点与根节点联系起来
        children1.add(childNode1);
        children1.add(childNode2);
        children1.add(childNode3);
        children1.add(childNode4);

        children2.add(childNode5);
        children2.add(childNode6);
        children2.add(childNode7);
        children2.add(childNode8);

        rootNode1.setChildren(children1);
        rootNode2.setChildren(children2);

        list.add(rootNode1);
        list.add(rootNode2);
        return list;
    }

    public void add(MenuForm menuForm){
       jxcMenuDao.add(menuForm);
    }
public void getFormData(MenuForm menuForm){

   jxcMenuDao.update(menuForm);


}


    public void delete(String id) {
        jxcMenuDao.delete(id);
    }
    public List<MenuTree> queryPid(String id){
        List<MenuTree>list= jxcMenuDaoI.queryPid(id);
        return list;
    }

}

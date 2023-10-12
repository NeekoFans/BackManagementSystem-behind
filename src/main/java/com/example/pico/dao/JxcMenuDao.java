package com.example.pico.dao;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.vo.MenuForm;
import com.example.pico.bean.vo.MenuTree;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Repository
public class JxcMenuDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    public void add(MenuForm menuForm){

        String sql="insert into jxc_menu(text_,icon_,url_,order_,pid_) values (?,?,?,?,?)";
        jdbcTemplate.update(sql,menuForm.getMenuName(),menuForm.getIcon(),
                menuForm.getMenuUrl(),menuForm.getOrdered(),menuForm.getPid());

    }
public List<Map<String, Object>> result(){
    String sql="select text_,id_,pid_ from jxc_menu where 1=1";
List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
return list;
}

public List<Map<String,Object>> getList(JxcMenu jxcMenu,String id){
    String sql="SELECT text_,id_,pid_ FROM(\n" +
            "      SELECT\n" +
            "      @ids AS _ids,\n" +
            "      (\n" +
            "      SELECT @ids := GROUP_CONCAT(id_)\n" +
            "      FROM jxc_menu\n" +
            "      WHERE FIND_IN_SET(pid_, @ids)\n" +
            "      ) AS cids,\n" +
            "      @l := @l+1 AS LEVEL\n" +
            "      FROM jxc_menu, (SELECT @ids := (?) , @l := 0 ) b\n" +
            "      WHERE @ids IS NOT NULL\n" +
            "      ) ID, jxc_menu DATA\n" +
            "WHERE FIND_IN_SET(id_, ID._ids)\n" +
            "ORDER BY LEVEL,id_";
   List<Map<String,Object>>list=jdbcTemplate.queryForList(sql,id);
   return list;
}
    public void update(MenuForm menuForm){
        String sql="update jxc_menu set text_=?,url_=?,order_=?,pid_=? where id_=?";
        jdbcTemplate.update(sql, menuForm.getMenuName(), menuForm.getMenuUrl(),
                menuForm.getOrdered(),menuForm.getPid(), menuForm.getId());
    }

    public void delete(String id){
        String sql="delete from jxc_menu where id_=? ";
        jdbcTemplate.update(sql,id);
    }

}

package com.example.pico.dao;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.JxcMenuRole;
import com.example.pico.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class LoginDao {
    @Resource
    private JdbcTemplate jdbc;
    public User getAccount(String account){
        String sql="select account,password from user where account=?";
        List<User> list=jdbc.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User u=new User();
                u.setAccount(rs.getString("account"));
                u.setPassword(rs.getString("password"));

                return u;
            }
        },account);
        if (list.size()==0){
            return null;
        }
        return list.get(0);
    }
    public List<JxcMenu> getMenuList(String account){
        String sql="SELECT text_ FROM jxc_menu \n" +
                "       WHERE id_ IN (SELECT menu_id_ FROM jxc_menu_role \n" +
                "       WHERE role_id_ IN(SELECT role_id_ FROM jxc_role_user \n" +
                "       WHERE user_id_ IN(SELECT id FROM `user` WHERE account=?)))";
        List<JxcMenu>list=jdbc.query(sql, new RowMapper<JxcMenu>() {
            @Override
            public JxcMenu mapRow(ResultSet rs, int rowNum) throws SQLException {
                JxcMenu jxcRole1=new JxcMenu();
                jxcRole1.setText(rs.getString("text_"));


                return jxcRole1;
            }
        },account);
        return list;
    }
}

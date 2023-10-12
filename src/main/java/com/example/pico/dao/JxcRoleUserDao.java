package com.example.pico.dao;

import com.example.pico.bean.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JxcRoleUserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    public List<JxcRoleUser> getList(JxcRoleUser jxcRoleUser, String id){
        String sql="select id_,role_id_,user_id_ from jxc_role_user where id_=? ";
        List<JxcRoleUser>list=jdbcTemplate.query(sql, new RowMapper<JxcRoleUser>() {
            @Override
            public JxcRoleUser mapRow(ResultSet resultSet, int i) throws SQLException {
                JxcRoleUser jxcRoleUser1=new JxcRoleUser();
                jxcRoleUser1.setId(resultSet.getString("id_"));
                jxcRoleUser1.setRoleId(resultSet.getString("role_id_"));
                jxcRoleUser1.setUserId(resultSet.getString("user_id_"));
                return jxcRoleUser1;
            }
        },id);
        return list;
    }

    public void addRoleUser(User user) {

        String sql="insert  into jxc_role_user (user_id_,role_id_) values(?,?)";
        for (String integer : user.getRoleIdList()) {
            jdbcTemplate.update(sql,user.getId(),integer);
        }

    }

    public List<JxcRoleUser> getById(Long id) {
        String sql="  SELECT\n" +
                "a.`role_id_`\n" +
                "FROM jxc_role_user a,jxc_role b\n" +
                "WHERE a.`role_id_`=b.`id_`\n" +
                "AND (b.`pid_`=0 OR b.`pid_`=19)\n" +
                "AND a.`user_id_`=?";
        List<JxcRoleUser>list=jdbcTemplate.query(sql, new RowMapper<JxcRoleUser>() {
            @Override
            public JxcRoleUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                JxcRoleUser jxcRoleUser1=new JxcRoleUser();
                jxcRoleUser1.setRoleId(rs.getString("role_id_"));


                return jxcRoleUser1;
            }
        },id);
        return list;
    }

    public void update(User user) {
        String sql="update jxc_role_user set name=?,account=? where id=?";

        jdbcTemplate.update(sql,user.getName(),user.getAccount(),user.getId());
    }

    public void delete(User user) {
        String sql="delete from jxc_role_user where user_id_=?";
        jdbcTemplate.update(sql,user.getId());
    }

    public void delete1(String id) {
        String sql="delete from jxc_role_user where user_id_=?";
        jdbcTemplate.update(sql,id);
    }
}

package com.example.pico.dao;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.JxcMenuRole;
import com.example.pico.bean.JxcRole;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JxcMenurRoleDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    public List<JxcMenuRole> getList(JxcMenuRole jxcMenuRole, String id){
        String sql="select id_,menu_id_,role_id_ from jxc_menu_role where id_=? ";
        List<JxcMenuRole>list=jdbcTemplate.query(sql, new RowMapper<JxcMenuRole>() {
            @Override
            public JxcMenuRole mapRow(ResultSet resultSet, int i) throws SQLException {
                JxcMenuRole jxcMenuRole1=new JxcMenuRole();
                jxcMenuRole1.setId(resultSet.getString("id_"));
                jxcMenuRole1.setMenuId(resultSet.getString("menu_id_"));
                jxcMenuRole1.setRoleId(resultSet.getString("role_id_"));
                return jxcMenuRole1;
            }
        },id);
        return list;
    }

    public void addMenuRole(JxcRole jxcRole) {

        String sql="insert  into jxc_menu_role (role_id_,menu_id_) values(?,?)";
        for (String integer : jxcRole.getMenuIdList()) {
            jdbcTemplate.update(sql,jxcRole.getId(),integer);
        }

    }

    public List<JxcMenuRole> getById(Long id) {
        String sql="  SELECT\n" +
                "a.`menu_id_`\n" +
                "FROM jxc_menu_role a,jxc_menu b\n" +
                "WHERE a.`menu_id_`=b.`id_`\n" +
                "AND (b.`pid_`=14 OR b.`pid_`=19)\n" +
                "AND a.`role_id_`=?";
        List<JxcMenuRole>list=jdbcTemplate.query(sql, new RowMapper<JxcMenuRole>() {
            @Override
            public JxcMenuRole mapRow(ResultSet rs, int rowNum) throws SQLException {
                JxcMenuRole jxcRole1=new JxcMenuRole();
                jxcRole1.setMenuId(rs.getString("menu_id_"));


                return jxcRole1;
            }
        },id);
        return list;
    }

    public void update(JxcRole jxcRole) {
        String sql="update jxc_menu_role set name_=?,flag_=? where id_=?";

        jdbcTemplate.update(sql,jxcRole.getName(),jxcRole.getFlag(),jxcRole.getId());
    }

    public void delete(JxcRole jxcRole) {
        String sql="delete from jxc_menu_role where role_id_=?";
        jdbcTemplate.update(sql,jxcRole.getId());
    }

    public void delete1(String id) {
        String sql="delete from jxc_menu_role where role_id_=?";
        jdbcTemplate.update(sql,id);
    }
}

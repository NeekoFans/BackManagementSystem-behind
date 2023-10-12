package com.example.pico.dao;

import com.example.pico.bean.JxcMenu;
import com.example.pico.bean.JxcRole;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class JxcRoleDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> total(){
        String sql=" select count(*) from jxc_role";
          List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
          return list;
    }

    public void addRole(JxcRole jxcRole) {
        String sql="insert into jxc_role(id_,pid_,name_,flag_) values(?,?,?,?)";
        jdbcTemplate.update(sql,jxcRole.getId(),jxcRole.getPid(),jxcRole.getName(),jxcRole.getFlag());
    }


    public List<JxcRole> getById(Long id) {
        String sql="select id_,  name_, flag_ from jxc_role where id_=?";
        List<JxcRole>list=jdbcTemplate.query(sql, new RowMapper<JxcRole>() {
            @Override
            public JxcRole mapRow(ResultSet rs, int rowNum) throws SQLException {
                JxcRole jxcRole1=new JxcRole();
                jxcRole1.setId(rs.getString("id_"));
                jxcRole1.setName(rs.getString("name_"));

                jxcRole1.setFlag(rs.getString("flag_"));

                return jxcRole1;
            }
        },id);
        return list;
    }

    public void update(JxcRole jxcRole) {
        String sql="update jxc_role set name_=?,flag_=? where id_=?";

        jdbcTemplate.update(sql,jxcRole.getName(),jxcRole.getFlag(),jxcRole.getId());
    }

    public void delete(String id) {
        String sql="delete from jxc_role where id_=?";
        jdbcTemplate.update(sql,id);
    }
}

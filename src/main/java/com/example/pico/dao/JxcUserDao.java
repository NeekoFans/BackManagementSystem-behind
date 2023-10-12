package com.example.pico.dao;

import com.example.pico.bean.JxcRole;
import com.example.pico.bean.User;
import com.example.pico.bean.vo.RoleTree;
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
public class JxcUserDao {
    @Resource
    private JdbcTemplate jdbcTemplate;
    public List<Map<String,Object>> total(){
        String sql=" select count(*) from user";
          List<Map<String,Object>> list=jdbcTemplate.queryForList(sql);
          return list;
    }

    public void addUser(User user) {
        String sql="insert into user(id,name,account,password,birthday) values(?,?,?,?,?)";
        jdbcTemplate.update(sql,user.getId(),user.getName(),user.getAccount(),
                user.getPassword(),user.getBirthday());
    }


    public List<User> getById(Long id) {
        String sql="select id,  name, account,birthday from user where id=?";
        List<User>list=jdbcTemplate.query(sql, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user1=new User();
                user1.setId(rs.getString("id"));
                user1.setName(rs.getString("name"));
                user1.setAccount(rs.getString("account"));
                Date birthday=rs.getDate("birthday");
                if (birthday!=null){
                    user1.setBirthday(birthday.toLocalDate());
                }

                return user1;
            }
        },id);
        return list;
    }

    public void update(User user) {
        String sql="update user set name=?,account=?,birthday=? where id=?";

        jdbcTemplate.update(sql,user.getName(),user.getAccount(),user.getBirthday(),user.getId());
    }

    public void delete(String id) {
        String sql="delete from user where id=?";
        jdbcTemplate.update(sql,id);
    }

    public List<RoleTree> query() {
            String sql="select id_,name_,pid_ from jxc_role";
        List<RoleTree>list=jdbcTemplate.query(sql, new RowMapper<RoleTree>() {
            @Override
            public RoleTree mapRow(ResultSet rs, int rowNum) throws SQLException {
                RoleTree user1=new RoleTree();
                user1.setId(rs.getString("id_"));
                user1.setLabel(rs.getString("name_"));

                user1.setPid(rs.getString("pid_"));

                return user1;
            }
        });
        return list;

    }

    public List<User> getUserList(User user) {
//        String sql="select * from jxc_role";
//        List<RoleTree>list=jdbcTemplate.query(sql, new RowMapper<RoleTree>() {
//            @Override
//            public RoleTree mapRow(ResultSet rs, int rowNum) throws SQLException {
//                RoleTree user1=new RoleTree();
//                user1.setId(rs.getString("id_"));
//                user1.setLabel(rs.getString("name_"));
//
//                user1.setPid(rs.getString("pid_"));
//
//                return user1;
//            }
//        });
//        return list;
        return null;

    }
}

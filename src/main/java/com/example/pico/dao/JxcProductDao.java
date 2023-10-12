package com.example.pico.dao;

import com.example.pico.bean.JxcProduct;
import com.example.pico.bean.JxcRole;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class JxcProductDao {
    @Resource
    private JdbcTemplate jdbcTemplate;


    public List<JxcProduct> selectByTypeId(String typeId) {

        String sql="select id_,type_id_,total_ from jxc_product where type_id_=? ";
        List<JxcProduct>list=jdbcTemplate.query(sql, new RowMapper<JxcProduct>() {
            @Override
            public JxcProduct mapRow(ResultSet resultSet, int i) throws SQLException {
                JxcProduct jxcProduct1=new JxcProduct();
                jxcProduct1.setId(resultSet.getString("id_"));
                jxcProduct1.setTypeId(resultSet.getString("type_id_"));
                jxcProduct1.setTotal(resultSet.getInt("total_"));
                return jxcProduct1;
            }
        },typeId);
        return list;
    }

    public void updateTotal(Integer total,String typeId) {
        String sql="update jxc_product set total_=? where type_id_=?";
        jdbcTemplate.update(sql,total,typeId);
    }

    public void addProduct(Integer total, String typeId) {
        String sql="insert into jxc_product(total_,type_id_) values(?,?)";
        jdbcTemplate.update(sql,total,typeId);
    }

    public void deleteBytypeId(String typeId) {
        String sql="delete from jxc_product where type_id_=? ";
        jdbcTemplate.update(sql,typeId);
    }
}

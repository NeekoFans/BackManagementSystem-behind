package com.example.pico.dao;

import com.example.pico.bean.JxcProductOrder;
import com.example.pico.bean.JxcType;
import com.example.pico.bean.vo.MenuForm;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class JxcTypeDao {
    @Resource
    JdbcTemplate jdbcTemplate;
    public void add(MenuForm menuForm) {
        String sql="insert into jxc_type(name_,p_id_) values (?,?)";
        jdbcTemplate.update(sql,menuForm.getMenuName(),menuForm.getPid());
    }

    public void update(MenuForm menuForm) {
        String sql="update jxc_type set name_=?,p_id_=? where id_=?";
        jdbcTemplate.update(sql, menuForm.getMenuName(), menuForm.getPid(), menuForm.getId());
    }

    public void delete(String id) {
        String sql="delete from jxc_type where id_=? ";
        jdbcTemplate.update(sql,id);
    }

    public List<JxcType> getTypeList(JxcType userBack){
        List<Object>param=new ArrayList<>();
        String sql="SELECT * FROM jxc_type t1,jxc_product t2 WHERE 1=1\n" +
                "        AND t1.`id_`=t2.`type_id_`";
        sql = addWhere(userBack, param, sql);
        sql=sql+"  order by t1.`id_` desc";
        sql=sql+ " limit ?,? ";
        param.add(userBack.getOffset());
        param.add(userBack.getPageSize());

        List<JxcType>list=jdbcTemplate.query(sql, new RowMapper<JxcType>() {
            @Override
            public JxcType mapRow(ResultSet rs, int rowNum) throws SQLException {
                JxcType userBack1=new JxcType();
                userBack1.setId(rs.getString("id_"));
                userBack1.setName(rs.getString("name_"));
                userBack1.setTotal(rs.getString("total_"));

                return userBack1;
            }
        },param.toArray());

        return list;
    }

    private String addWhere(JxcType userBack, List<Object> param, String sql) {

        if(!StringUtils.isEmpty(userBack.getName())){
            sql+=" and name_ like ? ";
            param.add("%"+userBack.getName()+"%");
        }

        return sql;
    }

    public
    List<Map<String, Object>> hasChild(String id) {
        String sql="SELECT id_ FROM (\n" +
                "             SELECT t1.id_,\n" +
                "             IF(FIND_IN_SET(p_id_, @pids) > 0, @pids := CONCAT(@pids, ',', id_), -1) AS ischild\n" +
                "             FROM (\n" +
                "                  SELECT id_,p_id_ FROM jxc_type t  ORDER BY p_id_, id_\n" +
                "                 ) t1,\n" +
                "                 (SELECT @pids := ?) t2\n" +
                "            ) t3 WHERE ischild != -1";
        List<Map<String, Object>> typeList=jdbcTemplate.queryForList(sql,id);
        System.out.println(typeList);
        return typeList;
    }

    public void addForm(JxcProductOrder jxcProductOrder) {
        String sql="insert into jxc_product_order(type_id_,number_,price_,creater_," +
                "order_type_,create_date_,status_) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,jxcProductOrder.getTypeId(),jxcProductOrder.getNumber(),
                jxcProductOrder.getPrice(),jxcProductOrder.getCreater(),
                jxcProductOrder.getOrderType(),jxcProductOrder.getCreateDate(),
                jxcProductOrder.getStatus());
    }

    public void sellForm(JxcProductOrder jxcProductOrder) {
        String sql="insert into jxc_product_order(type_id_,number_,price_,creater_," +
                "order_type_,create_date_,status_) values(?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql,jxcProductOrder.getTypeId(),jxcProductOrder.getNumber(),
                jxcProductOrder.getPrice(),jxcProductOrder.getCreater(),
                jxcProductOrder.getOrderType(),jxcProductOrder.getCreateDate(),
                jxcProductOrder.getStatus());
    }
}

package com.example.pico.dao;

import com.example.pico.bean.JxcProduct;
import com.example.pico.bean.JxcProductOrder;
import com.example.pico.bean.JxcRole;
import com.example.pico.bean.JxcType;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.thymeleaf.util.StringUtils;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class JxcProductOrderDao {
    @Resource
    private JdbcTemplate jdbcTemplate;


    public List<JxcProductOrder> getOrderList(JxcProductOrder userBack) {
        List<Object>param=new ArrayList<>();
        String sql="SELECT * FROM jxc_product_order t1,jxc_type t2\n" +
                "                WHERE 1=1\n" +
                "                AND t1.`type_id_`=t2.`id_`\n" +
                "                AND t1.`order_type_`=2" ;
        sql = addWhere(userBack, param, sql);
        sql=sql+"  order by t1.`type_id_` desc";
        sql=sql+ " limit ?,? ";
        param.add(userBack.getOffset());
        param.add(userBack.getPageSize());

        List<JxcProductOrder>list=jdbcTemplate.query(sql, new RowMapper<JxcProductOrder>() {
            @Override
            public JxcProductOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                JxcProductOrder userBack1=new JxcProductOrder();
                userBack1.setId(rs.getString("id_"));
                userBack1.setName(rs.getString("name_"));
                userBack1.setNumber(rs.getInt("number_"));
                userBack1.setPrice(rs.getString("price_"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date createTime = rs.getTimestamp("create_date_");
                userBack1.setCreateDate(simpleDateFormat.format(createTime));
                userBack1.setStatus(rs.getInt("status_"));
                userBack1.setReason(rs.getString("reason"));
                return userBack1;
            }
        },param.toArray());

        return list;

    }
    public List<JxcProductOrder> getAddList(JxcProductOrder userBack) {
        List<Object>param=new ArrayList<>();
        String sql="SELECT * FROM jxc_product_order t1,jxc_type t2\n" +
                "                WHERE 1=1\n" +
                "                AND t1.`type_id_`=t2.`id_`\n" +
                "                AND t1.`order_type_`=1" ;
        sql = addWhere(userBack, param, sql);
        sql=sql+"  order by t1.`type_id_` desc";
        sql=sql+ " limit ?,? ";
        param.add(userBack.getOffset());
        param.add(userBack.getPageSize());

        List<JxcProductOrder>list=jdbcTemplate.query(sql, new RowMapper<JxcProductOrder>() {
            @Override
            public JxcProductOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                JxcProductOrder userBack1=new JxcProductOrder();
                userBack1.setId(rs.getString("id_"));
                userBack1.setName(rs.getString("name_"));
                userBack1.setNumber(rs.getInt("number_"));
                userBack1.setPrice(rs.getString("price_"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date createTime = rs.getTimestamp("create_date_");
                userBack1.setCreateDate(simpleDateFormat.format(createTime));
                userBack1.setStatus(rs.getInt("status_"));
                userBack1.setReason(rs.getString("reason"));
                return userBack1;
            }
        },param.toArray());

        return list;

    }
    private String addWhere(JxcProductOrder userBack, List<Object> param, String sql) {

        if(!StringUtils.isEmpty(userBack.getName())){
            sql+=" and name_ like ? ";
            param.add("%"+userBack.getName()+"%");
        }

        return sql;
    }


    public void delete(String id) {
        String sql="delete from jxc_product_order where id_=? ";
        jdbcTemplate.update(sql,id);
    }

    public List<JxcProductOrder> getById(Long id) {
        String sql="select price_, number_ from jxc_product_order where id_=?";
        List<JxcProductOrder>list=jdbcTemplate.query(sql, new RowMapper<JxcProductOrder>() {
            @Override
            public JxcProductOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                JxcProductOrder jxcRole1=new JxcProductOrder();
                jxcRole1.setPrice(rs.getString("price_"));

                jxcRole1.setNumber(rs.getInt("number_"));

                return jxcRole1;
            }
        },id);
        return list;

    }

    public void update(JxcProductOrder jxcRole) {

        String sql="update jxc_product_order set number_=?,price_=?,status_=? where id_=?";

        jdbcTemplate.update(sql,jxcRole.getNumber(),jxcRole.getPrice(),jxcRole.getStatus(),jxcRole.getId());
    }

    public List<JxcProductOrder> reviewList(JxcProductOrder userBack) {
        List<Object>param=new ArrayList<>();
        String sql="SELECT * FROM jxc_product_order t1,jxc_type t2\n" +
                "                WHERE 1=1\n" +
                "                AND t1.`type_id_`=t2.`id_`\n";

        if (userBack.getOrderType()==0){
            sql = addWhere(userBack, param, sql);
            sql=sql+"  order by t1.`type_id_` desc";
            sql=sql+ " limit ?,? ";
            param.add(userBack.getOffset());
            param.add(userBack.getPageSize());
        }else{
            //下面两条sql语句的顺序不能反了，不然返回结果为空
            sql = addWhere(userBack, param, sql);
            sql=sql+" AND t1.`order_type_`=? ";
            sql=sql+"  order by t1.`type_id_` desc";
            sql=sql+ " limit ?,? ";
            param.add(userBack.getOrderType());
            param.add(userBack.getOffset());
            param.add(userBack.getPageSize());
        }




        List<JxcProductOrder>list=jdbcTemplate.query(sql, new RowMapper<JxcProductOrder>() {
            @Override
            public JxcProductOrder mapRow(ResultSet rs, int rowNum) throws SQLException {
                JxcProductOrder userBack1=new JxcProductOrder();
                userBack1.setId(rs.getString("id_"));
                userBack1.setTypeId(rs.getString("type_id_"));
                userBack1.setName(rs.getString("name_"));
                userBack1.setNumber(rs.getInt("number_"));
                userBack1.setPrice(rs.getString("price_"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date createTime = rs.getTimestamp("create_date_");
                userBack1.setCreateDate(simpleDateFormat.format(createTime));
                userBack1.setStatus(rs.getInt("status_"));
                userBack1.setOrderType(rs.getInt("order_type_"));
                userBack1.setCreater(rs.getString("creater_"));

                return userBack1;
            }
        },param.toArray());

        return list;

    }

    public Long reviewTotal(Integer orderType) {
        String sql = "select count(*) from jxc_product_order\n" +
                "         where 1=1";
        if (orderType==1||orderType==2) {

            sql = sql += " AND order_type_=? ";
            Map<String, Object> map = jdbcTemplate.queryForMap(sql, orderType);
            Long total = (Long) map.get("count(*)");

            return total;
        } else {
            Map<String, Object> map = jdbcTemplate.queryForMap(sql);
            Long total = (Long) map.get("count(*)");
            return total;
        }
    }

    public void editBytypeId(String typeId) {

        String sql="update jxc_product_order set status_=? where 1=1 " +
                " and type_id_=? " +
                " and order_type_=1 ";

        jdbcTemplate.update(sql,3,typeId);

    }

    public void deleteBytypeId(String typeId) {
        String sql="delete from jxc_product_order where type_id_=? ";
        jdbcTemplate.update(sql,typeId);
    }

    public void refuseBytypeId(String typeId) {
        String sql="update jxc_product_order set status_=? where 1=1 " +
                " and type_id_=? " +
                " and order_type_=2 ";

        jdbcTemplate.update(sql,2,typeId);
    }

    public void editOutBytypeId(String typeId) {
        String sql="update jxc_product_order set status_=? where 1=1 " +
                " and type_id_=? " +
                " and order_type_=2 ";

        jdbcTemplate.update(sql,3,typeId);
    }

    public void endByTypeId(String typeId,String orderType,String reason) {
        String sql="update jxc_product_order set status_=?,reason=? where 1=1 " +
                " and type_id_=? " +
                " and order_type_=? ";


        jdbcTemplate.update(sql,2,reason,typeId,orderType);
    }

    public void reason(String reason,String typeId,String orderType) {
        String sql="update jxc_product_order set reason=? where 1=1 " +
                " and type_id_=? " +
                " and order_type_=? ";
        jdbcTemplate.update(sql,reason,typeId,orderType);
    }
}

package com.example.pico;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@MapperScan({"com.example.pico.dao"})
@SpringBootApplication
public class PicoApplication {
    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("id","9527");
        map.put("name","张三");
        map.put("age","20");
        map.put("date",new Date());
        map.put("str",1111111);
        SpringApplication.run(PicoApplication.class, args);
    }

}

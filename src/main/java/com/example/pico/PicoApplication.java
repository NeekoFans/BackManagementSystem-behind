package com.example.pico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class PicoApplication {


    public static void main(String[] args) {
        Map map=new HashMap();
        map.put("id","9527");
        map.put("name","张三");
        map.put("age","20");
        map.put("date",new Date());
        map.put("str",1111111);
        map.put("str2","22222222222222222222");
        SpringApplication.run(PicoApplication.class, args);
    }

}

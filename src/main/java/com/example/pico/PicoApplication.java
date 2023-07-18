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
        map.put("id","952711111wwwwwwwwwwwwwwwww1111111");
        map.put("name","张三");
        map.put("age","20");
        map.put("date",new Date());
        SpringApplication.run(PicoApplication.class, args);
    }

}

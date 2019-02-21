package com.zh.provider1;

import com.zh.provider1.Entrty.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class Provider1Application {

    public static void main(String[] args) {
        SpringApplication.run(Provider1Application.class, args);
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public Object home(@RequestParam String name)
    {
        Map<String, Object> map = new HashMap<>();
        User user  = new User();
        user.setName("zzz");
        user.setUid(1);
        String s =  "hi " + name + ",i am from port:" + port;
        map.put("user", user);
        map.put("str", s);
        return map;
    }
}

package com.spring.boot;

import com.spring.boot.config.AuthorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 演示@ConfigurationProperties注解的启动类
 */
@RestController
@SpringBootApplication
public class AuthorConfigApplication{
    @Autowired
    private AuthorConfig authorConfig;

    /**
     * 访问入口
     */
    @RequestMapping("/")
    String author(){
        return "作者:" + authorConfig.getName() + "  业余爱好:" + authorConfig.getHobby();
    }

    public static void main(String[] args) {
        SpringApplication.run(AuthorConfigApplication.class, args);
    }
}

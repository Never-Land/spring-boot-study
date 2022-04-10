package com.spring.boot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SpringBoot学习Hello应用演示
 * SpringBootApplication是SpringBoot项目的核心注解，主要目的是开启自动配置
 * SpringBoot的启动图案可以替换或者是关闭，具体方式需参考官网最细方式
 * 说明:@ImportResource注解可以来加载xml配置
 *
 * SpringBoot打成jar包项目，可以使用java -jar xx.jar 运行项目，--server.port=9090修改Tomcat端口号
 */
//注释是为了不让AuthorConfigApplication启动报错
//@RestController
@SpringBootApplication
public class HelloApplication{
    /**
     * 学习作者名
     */
    @Value("${study.author}")
    private String studyAuthor;
    /**
     * 学习内容
     */
    @Value("${study.content}")
    private String studyContent;

    /**
     * 疑问：启动main方法之后，浏览器输入http://localhost:8080/为什么会出现Hello的返回值?
     */
    @RequestMapping("/")
    String Hello(){
        return "学习者:" + this.studyAuthor + "  学习内容:" + this.studyContent;
    }

    /**
     * 启动的入口
     */
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }
}

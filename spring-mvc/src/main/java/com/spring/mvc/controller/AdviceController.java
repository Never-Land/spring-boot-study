package com.spring.mvc.controller;

import com.spring.mvc.domain.DemoDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 演示对于控制器全局配置控制器
 */
@Controller
public class AdviceController{
    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoDomain demoDomain){
        throw new IllegalArgumentException("非常抱歉，参数有误!" + "来自@ModelAttribute:" + msg);
    }
}

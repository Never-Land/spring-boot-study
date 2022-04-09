package com.spring.mvc.controller;

import com.spring.mvc.domain.DemoDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * SpringMVC注解演示控制器
 *
 * 乱码问题处理:配置的Tomcat在VM options栏增加参数-Dfile.encoding=UTF-8
 */
@Controller
@RequestMapping("/annotation")
public class DemoAnnotationController {
    /**
     * index
     */
    @RequestMapping(produces = {"text/plain;charset=UTF-8"})
    public @ResponseBody String index(HttpServletRequest request){
        return "url:" + request.getRequestURL() + "可以访问";
    }
    /**
     * 演示路径传入参数,例如:/annotation/pathVar/test
     */
    @RequestMapping(value = "/pathVar/{params}", produces = {"text/plain;charset=UTF-8"})
    public @ResponseBody String demoPathVar(@PathVariable String params, HttpServletRequest request){
        return "url:" + request.getRequestURL() + "可以访问PARAMS:" + params;
    }

    /**
     * 演示通过请求地址传参,例如:/annotation/requestParam?id=1
     */
    @RequestMapping(value = "/requestParam", produces = {"text/plain;charset=UTF-8"})
    public @ResponseBody String passRequestParam(Long id, HttpServletRequest request){
        return "url:" + request.getRequestURL() + "可以访问ID:" + id;
    }
    /**
     * 演示解释参数到对象,例如:/annotation/object?id=1&name=yy
     * 注解@Response可以用在方法上
     */
    @RequestMapping(value = "/object", produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String passObject(DemoDomain demoDomain, HttpServletRequest request){
        return "url:" + request.getRequestURL() + "可以访问对象ID:" + demoDomain.getId()
                + ",NAME:" + demoDomain.getName();
    }
    /**
     * 演示不同地址映射到相同方法上,例如:/annotation/requestOne或/annotation/requestTwo
     */
    @RequestMapping(value = {"/requestOne", "/requestTwo"}, produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String remove(HttpServletRequest request){
        return "url:" + request.getRequestURL() + "可以访问";
    }
}

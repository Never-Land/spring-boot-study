package com.spring.mvc.controller;

import com.spring.mvc.domain.DemoDomain;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 演示@RestController注解控制器,返回数据时不需要使用@ResponseBody注解
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController{
    /**
     * 返回数据类型为json格式
     */
    @RequestMapping(value = "/getJson", produces = {"application/json;charset=UTF-8"})
    public DemoDomain getJson(DemoDomain demoDomain){
        return this.packTestData(demoDomain);
    }

    /**
     * 返回数据类型为xml格式，注意:要需要引入支持xml格式数据
     */
    @RequestMapping(value = "/getXml", produces = {"application/xml;charset=UTF-8"})
    public DemoDomain getXml(DemoDomain demoDomain){
        return this.packTestData(demoDomain);
    }

    /**
     * 组装测试数据
     */
    private DemoDomain packTestData(DemoDomain demoDomain){
        long id = 1L;
        String name = "test";
        if(Objects.nonNull(demoDomain.getId())){
            id = id + 1L;
        }
        if(StringUtils.isNotBlank(name)){
            name = name + "yy";
        }
        return new DemoDomain(id, name);
    }
}


package com.spring.mvc.controller;

import com.spring.mvc.domain.DemoDomain;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 演示自定义converter
 */
@Controller
public class ConvertController{
    @RequestMapping(value = "/convert", produces = {"application/x-wisely"})
    @ResponseBody
    public DemoDomain convert(@RequestBody DemoDomain demoDomain){
        return demoDomain;
    }
}

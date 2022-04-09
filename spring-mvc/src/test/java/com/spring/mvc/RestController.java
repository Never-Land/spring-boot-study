package com.spring.mvc;

import com.spring.mvc.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Rest控制器
 */
@Controller
public class RestController{
    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/testRest", produces = {"text/plain;charset=UTF-8"})
    @ResponseBody
    public String testRest(){
        return demoService.saySomething();
    }

}

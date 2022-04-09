package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * 演示基于SSE的服务器端推送事件
 */
@Controller
public class SseController{
    /**
     * 每5秒向浏览器随机推送随机消息
     * 问题:页面使用jQuery报错,待处理
     */
    @RequestMapping(value = "/push", produces = {"text/event-stream"})
    @ResponseBody
    public String push(){
        Random random = new Random();
        try {
            Thread.sleep(TimeUnit.MILLISECONDS.toMillis(5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + random.nextInt() + "\n\n";
    }
}

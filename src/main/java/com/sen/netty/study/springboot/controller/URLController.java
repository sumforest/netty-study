package com.sen.netty.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author: Sen
 * @date 2020/5/26 0026 15:36
 * @description:
 */
@Controller
public class URLController {

    @GetMapping("/")
    public String WebsocketClient(){
        return "/WebsocketChatClient";
    }
}

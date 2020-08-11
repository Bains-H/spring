package com.itheima.controller;

import com.itheima.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huang.b.h.
 * @date 2020/8/11 14:52
 * @DESC:
 */

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping(value = "/show")
    public String show(@RequestParam(value = "name",required = false) String name) {
        System.out.println("show running.....");
        demoService.show1();
        return "index";
    }
}

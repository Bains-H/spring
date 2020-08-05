package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author huang.b.h.
 * @date 2020/7/31 17:40
 * @DESC:
 */

@Controller
public class TargetController {

    @RequestMapping(value = "/target")
    public ModelAndView show(){
        System.out.println("目标资源执行.....");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name","itcast");
        modelAndView.setViewName("index");
        return modelAndView;
    }
}

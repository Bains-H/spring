package com.itheima.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author huang.b.h
 * @date 2020/7/28 10:19
 * @DESC:
 */

@Controller
@RequestMapping("/user")
public class UserController {
    //请求地址 http://localhost:8080/user/quick
    @RequestMapping(value = "/quick",method = RequestMethod.GET)
    public String save(){
        System.out.println("Controller save running....");
        return "success";
    }

    @RequestMapping(value = "/quick2")
    private ModelAndView save2(){
        //Model：模型 作用封装数据
        //View：视图 作用展示数据
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username","itcase");
        //设置视图名称
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick3")
    public ModelAndView save3(ModelAndView modelAndView){
        modelAndView.addObject("username","itheima");
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping(value = "/quick4")
    public String save4(Model model){
        model.addAttribute("username","博学谷");
        return "success";
    }

    @RequestMapping(value = "/quick5")
    public String save5(HttpServletRequest request){
        request.setAttribute("username","酷丁鱼");
        return "success";
    }

    @RequestMapping(value = "/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        response.getWriter().print("hello itcase");
    }

    @RequestMapping(value = "/quick7")
    @ResponseBody  //告知SpringMVC 不进行视图跳转 直接进行数据响应
    public String save7(){
        return "hello itheima";
    }

    @RequestMapping(value = "/quick8")
    @ResponseBody
    public String save8(){
        return "{\"username\":\"zhangsan\",\"age\":18}";
    }

    @RequestMapping(value = "/quick9")
    @ResponseBody
    public String save9() throws IOException {
        User user = new User();
        user.setUsername("lisi");
        user.setAge(20);
        //使用json的转换工具将对象装换成json格式字符串再返回
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    @RequestMapping(value = "/quick10")
    @ResponseBody
    //期望SpringMVC自动将User转换成json格式的字符串
    public User save10() {
        User user = new User();
        user.setUsername("wangwu");
        user.setAge(30);
        return user;
    }
}

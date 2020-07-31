package com.itheima.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.domain.Vo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

    @RequestMapping(value = "/quick11")
    @ResponseBody
    public void save11(String username,int age){
        System.out.println(username);
        System.out.println(age);
    }

    @RequestMapping(value = "/quick12")
    @ResponseBody
    public void save12(User user){
        System.out.println(user);
    }

    @RequestMapping(value = "/quick13")
    @ResponseBody
    public void save13(String[] strs){
        System.out.println(Arrays.asList(strs));
    }

    @RequestMapping(value = "/quick14")
    @ResponseBody
    public void save14(Vo vo){
        System.out.println(vo);
    }

    @RequestMapping(value = "/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList){
        System.out.println(userList);
    }

    @RequestMapping(value = "/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name",required = false,defaultValue = "itcase") String username){
        System.out.println(username);
    }

    // localhost:8080/user/quick17/zhangsan
    @RequestMapping(value = "/quick17/{name}")
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username){
        System.out.println(username);
    }

    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date){
        System.out.println(date);
    }

    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(HttpServletRequest request, HttpServletResponse response, HttpSession session){
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
    }

    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(@RequestHeader(value = "User-Agent",required = false) String user_agent){
        System.out.println(user_agent);
    }

    @RequestMapping(value = "/quick21")
    @ResponseBody
    public void save21(@CookieValue(value = "JSESSIONID",required = false) String jsessionid){
        System.out.println(jsessionid);
    }

    @RequestMapping(value = "/quick22")
    @ResponseBody
    public void save22(String username, MultipartFile uploadFile) throws IOException {
        System.out.println(username);
        //获得上传文件名称
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("E:\\练习项目\\测试数据\\"+originalFilename));
    }

    @RequestMapping(value = "/quick23")
    @ResponseBody
    public void save23(String username, MultipartFile[] uploadFiles) throws IOException {
        System.out.println(username);
        //获得上传文件名称
        for (MultipartFile uploadFile:uploadFiles){
            String originalFilename = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("E:\\练习项目\\测试数据\\"+originalFilename));
        }
    }
}

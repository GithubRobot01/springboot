package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class HelloController {
    /**
     *RequestMapping: 设置请求路径,get和post请求都支持
     *GetMapping: 设置请求路径,支持get请求
     *PostMapping: 设置请求路径,支持post请求
     */
    @Autowired
    private UserService userService;

    @Autowired
    private DataSource dataSource;
    @Value("${itcast.url}")
    private String itcastUrl;
    @Value("${itheima.url}")
    private String itheimaUrl;

    @GetMapping("hello")
    public String hello(){
        System.out.println(itcastUrl);
        System.out.println(itheimaUrl);
        System.out.println("DataSource:"+dataSource);
        return "Hello,SpringBoot!";
    }

    @GetMapping("/user/{id}")
    public User findById(@PathVariable("id") Long id){
        return userService.findById(id);
    }
}

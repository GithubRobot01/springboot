package cn.itcast;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * spring boot工程都有一个启动引导类,这是工程的入口类
 * 并在引导类上添加@SpringBootApplication
 *
 * SpringBootApplication是springboot的核心注解,有很多功能,主要功能之一是包扫描(只能扫描启动类所在包或者是子包下的注解)
 */
@SpringBootApplication
//扫描mybatis所有的业务mapper接口
//@MapperScan("cn.itcast.mapper")

@MapperScan("cn.itcast.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

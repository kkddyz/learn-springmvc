package cn.itcast.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author kkddyz
 * <p>
 * 控制器类
 */

@Controller
public class HelloController {

    @RequestMapping(path = "/hello")
    public String sayHello() {
        System.out.println("hello StringMVC");

        // 视图解析器,将Controller的结果处理为视图对象，默认返回jsp文件
        return "success";
    }
}

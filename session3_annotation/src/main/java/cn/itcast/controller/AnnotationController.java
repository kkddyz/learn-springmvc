package cn.itcast.controller;

import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import java.util.Date;
import java.util.Map;


/**
 * @author kkddyz
 * <p>
 * 学习常用注解
 */
@Controller
@RequestMapping("/anno")
// 在session中共享request.msg
@SessionAttributes(value = {"msg"})
public class AnnotationController {

    @RequestMapping("/testRequestParam")

    public String testRequestParam(@RequestParam(name = "oldParamName", required = false) String newParamName) {
        System.out.println("打印newParamName:" + newParamName);
        return "success";
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println("打印请求体内容: " + body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") String id) {

        System.out.println("打印路径中占位符的值: " + id);
        return "success";
    }


    ///**
    // * ModelAttribute注解在方法上，让该方法在在控制器方法之前执行 : 从数据库中查询缺失信息，得到完整User对象。
    // */
    //@ModelAttribute
    //public User getCompleteUser(User user) {
    //    // 模拟从数据库查询到date
    //    Date date = new Date();
    //    // 将完整数据封装到User对象
    //    user.setDate(date);
    //
    //    return user;
    //}
    //
    ///**
    // * 由于getCompleteUser,提供了需要的user对象，因此不会重新封装参数到User
    // */
    //@RequestMapping("/testModelAttribute")
    //public String testModelAttribute(User user) {
    //    System.out.println("执行了testModelAttribute()");
    //    System.out.println(user);
    //    return "success";

    //}


    /**
     * ModelAttribute注解在方法上，让该方法在在控制器方法之前执行 : 从数据库中查询缺失信息，得到完整User对象。
     */
    @ModelAttribute
    public void getCompleteUser(User user, Map<String, User> map) {
        // 模拟从数据库查询到date
        Date date = new Date();
        // 将完整数据封装到User对象
        user.setDate(date);

        // 将user存储到map
        map.put("user", user);
    }

    /**
     * ModelAttribute注解在参数上，从Map获取对象
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user) {
        System.out.println("执行了testModelAttribute()");
        System.out.println(user);
        return "success";
    }


    /**
     * 添加attribute
     *
     * 使用Model对象将数据存储到Request域,然后通过SessionAttribute注解将数据拷贝到session
     *
     * Mode接口抽象了request域对象,在Model中存对象，最终会存到request域对象中
     *
     * spring提供Model接口的实现类ExtendedModelMap extends ModelMap implement Model
     *                                                  ModelMap extends LinkedHashMap
     */
    @RequestMapping("/addSessionAttributes")
    public String testSessionAttributes(Model model) {
        System.out.println("addSessionAttributes...");
        model.addAttribute("msg", "hello");
        return "success";
    }

    /**
     * 获取attribute(request)
     */
    @RequestMapping(value = "/getSessionAttributes")
    public String getSessionAttributes(ModelMap modelMap) {
        System.out.println("getSessionAttributes...");
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除attribute(request域)
     */
    @RequestMapping(value = "/delSessionAttributes")
    public String delSessionAttributes(SessionStatus status) {
        System.out.println("delSessionAttributes...");
        status.setComplete();
        return "success";
    }
}

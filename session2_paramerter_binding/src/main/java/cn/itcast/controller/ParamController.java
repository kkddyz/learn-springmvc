package cn.itcast.controller;

import cn.itcast.domain.Account;
import cn.itcast.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @author kkddyz
 * @date 2022/5/19
 * @description 参数绑定
 */
@Controller
@RequestMapping("/param")
public class ParamController {

    /**
     * 测试基本类型的绑定
     * 使用@RequestMapping保证需要的参数存在
     */
    @RequestMapping(path = "/testPrimitive", params = {"username", "age"})
    public String bindingPrimitiveTypeAndString(String username, int age) {
        System.out.println("获取基本类型和字符串");

        System.out.println("username=" + username + ",age=" + age);
        return "success";
    }

    /**
     * User对象中只有基本类型数据
     */
    @RequestMapping(path = "/saveUser", method = {RequestMethod.POST}, params = {"username", "password"})
    public String saveUser(User user) {
        System.out.println("获取到user");
        System.out.println(user);
        return "success";
    }

    /**
     * Account对象中有一个User类的owner对象,表示账户的所有者
     */
    @RequestMapping(path = "/saveAccount", method = {RequestMethod.POST},
            params = {"owner.username", "owner.password", "money"})
    public String saveUserWithAccount(Account account) {
        System.out.println("获取到account");


        System.out.println(account);
        return "success";
    }

    /**
     * User拥有多个account对象，内部使用list存储
     */
    @RequestMapping(path = "/saveUserWithAccounts", method = {RequestMethod.POST})
    public String saveUserWithAccounts(User user) {
        System.out.println("带有账户的user");
        System.out.println(user);
        return "success";
    }

    /**
     * 测试是否能解析 2020-2-2
     */
    @RequestMapping(path = "/testDate")
    public String testToday(Date today) {
        System.out.println("今天是:" + today.toString());
        return "success";
    }

    /**
     * 测试是否能直接得到req,resp
     */
    @RequestMapping("/testReqResp")
    public String getReqResp(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println(req);
        System.out.println(resp);
        return "success";
    }
}

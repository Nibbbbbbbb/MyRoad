package cn.noobbb.myroadsys.controller;

import cn.noobbb.myroadutils.hello.HelloUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: chenbihao
 * @create: 2020/12/3
 * @Description:
 * @History:
 */
@RestController
@RequestMapping("/sys")
public class HelloController {

    @Value("${cn.noobbb.name}")
    String blogName;
    @Value("${cn.noobbb.title}")
    String blogTitle;

    @GetMapping(value = "hello")
    public String hello() {
        return HelloUtils.getHello() + ",This is my blog," + blogName + " " + blogTitle;
    }


}

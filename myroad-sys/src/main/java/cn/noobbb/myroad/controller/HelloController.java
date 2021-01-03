package cn.noobbb.myroad.controller;

import cn.noobbb.myroad.hello.HelloUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(tags = "hello模块")
@RestController
@RequestMapping("/sys")
public class HelloController {

    @Value("${cn.noobbb.name}")
    String blogName;
    @Value("${cn.noobbb.title}")
    String blogTitle;


    @ApiOperation(value = "hello")
    @GetMapping(value = "hello")
    public String hello() {
        return HelloUtils.getHello() + ",This is my blog," + blogName + " " + blogTitle;
    }


}

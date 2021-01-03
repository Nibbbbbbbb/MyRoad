package cn.noobbb.myroad.service;

import cn.noobbb.myroad.MyroadSysApplication;
import cn.noobbb.myroad.domain.SysUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import javax.annotation.Resource;

/**
 * @author: chenbihao
 * @create: 2020/12/3
 * @Description:
 * @History:
 */
@SpringBootTest(classes = {MyroadSysApplication.class})
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class SysUserServiceTest {

    @Resource
    private ISysUserService userService;



    @Test
    public void TestHello() throws Exception {
        SysUser user = new SysUser();
        user.setNickname("nibbbbbbbb").setUsername("noobbb").setPassword("5233");
        userService.save(user);
        Assertions.assertNotNull(user.getId());
        Assertions.assertNotNull(user.getCreateTime());
        Assertions.assertNull(user.getUpdateTime());
        userService.updateById(user);
        Assertions.assertNotNull(user.getCreateTime());
        Assertions.assertNotNull(user.getUpdateTime());

    }
}
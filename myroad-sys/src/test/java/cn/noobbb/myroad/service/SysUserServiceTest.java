package cn.noobbb.myroad.service;

import cn.noobbb.myroad.MyroadSysApplication;
import cn.noobbb.myroad.domain.SysUser;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author: chenbihao
 * @create: 2020/12/3
 * @Description:
 * @History:
 */
@ActiveProfiles("test")
@SpringBootTest(classes = {MyroadSysApplication.class})
@AutoConfigureMockMvc
@Transactional
public class SysUserServiceTest {

    @Resource
    private SysUserService userService;

    @Test
    public void TestServiceCRUD() throws Exception {
        SysUser user = new SysUser();
        user.setNickname("nibbbbbbbb").setUsername("noobbb").setPassword("5233");
        userService.save(user);
        assertNotNull(user.getId());
        assertNotNull(user.getCreateTime());
        assertNull(user.getUpdateTime());
        userService.updateById(user);
        assertNotNull(user.getCreateTime());
        assertNotNull(user.getUpdateTime());

        SysUser noobbb = userService.getOne(Wrappers.<SysUser>lambdaQuery().eq(SysUser::getUsername, "noobbb"));
        assertNotNull(noobbb);
    }
}
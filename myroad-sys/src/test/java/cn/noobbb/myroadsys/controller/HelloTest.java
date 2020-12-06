package cn.noobbb.myroadsys.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.annotation.Resource;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: chenbihao
 * @create: 2020/12/3
 * @Description:
 * @History:
 */
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class HelloTest {
    @Resource
    private MockMvc mvc;
    @Value("${cn.noobbb.name}")
    String blogName;
    @Value("${cn.noobbb.title}")
    String blogTitle;


    @Test
    public void TestHello() throws Exception {
        ResultActions resultActions = mvc.perform(MockMvcRequestBuilders.get("/sys/hello").accept(MediaType.APPLICATION_JSON));
        //设置编码
        resultActions.andReturn().getResponse().setCharacterEncoding("UTF-8");
        resultActions.andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello~,This is my blog," + blogName + " " + blogTitle)));
    }
}
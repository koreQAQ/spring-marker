package org.example.spring.marker.web.controller;

import org.example.spring.marker.web.aspect.ControllerAspect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.net.URI;

/**
 * Created by lishubin on 2020/8/22 9:01 下午
 */
public class GreetingControllerTest  extends AbstractWebUnitTest {

    private MockMvc mockMvc;

    private String helloMessage;

    @BeforeEach
    void setUp() {


        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        // 视图解析只是使用jsp来模拟转发路径，但没有把Model应用到View中，这一点在
        // ServletConfig中配置了FreeMarker来解决
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".ftl");

        GreetingController controller = new GreetingController();
        // 构建Controller层的测试
        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setViewResolvers(viewResolver)
                .setControllerAdvice(new ControllerAspect())
                .build();
        helloMessage = "hello,spring-marker";

    }

    @Test
    void greeting() throws Exception {

        //因为请求路径与视图名称一样，必须设置对应的转发前缀、后缀，这一点在视图解析器中设置
        // 而没有使用Spring上下文，导致没有启用freeMarker的配置类，会
        mockMvc.perform(
                MockMvcRequestBuilders.get("/greeting")
                        .param("message", helloMessage)
        )
                .andDo(MockMvcResultHandlers.log())
                // 跳转视图名称
                .andExpect(MockMvcResultMatchers.view().name("greeting"));

    }


    @Test
    void exception() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(URI.create("/exception")))
                .andDo(MockMvcResultHandlers.log())
                .andExpect(MockMvcResultMatchers.view().name("error/duplicate"));
    }
}
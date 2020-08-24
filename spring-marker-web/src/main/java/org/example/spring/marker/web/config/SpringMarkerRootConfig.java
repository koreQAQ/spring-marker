package org.example.spring.marker.web.config;

import org.springframework.context.annotation.Configuration;

/**
 * Web是一个集成模块的总类，对外提供服务
 * RootConfig 用于扫描除了web包下无关的其他Bean，同时与ServletConfig构成2个不同的上下文
 * Created by lishubin on 2020/8/22 6:14 下午
 *
 * @author lishubin
 */
@Configuration
//除了Web之外的Bean
//不然LogAspect 注册在RootConfig的上下文中
// 而Controller 注册在WebServlet的上下文中二者不是同一个上下文
//@ComponentScan(value = "org.example.spring.marker.web",excludeFilters = {
//        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
//})
public class SpringMarkerRootConfig {

}

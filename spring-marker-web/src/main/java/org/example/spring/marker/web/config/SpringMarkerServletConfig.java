package org.example.spring.marker.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * Created by lishubin on 2020/8/22 6:14 下午
 *
 * @author lishubin
 */
@Configuration
@ComponentScan(basePackages =  {"org.example.spring.marker.web"})
@EnableWebMvc
@EnableAspectJAutoProxy
public class SpringMarkerServletConfig implements WebMvcConfigurer {


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 模板注册仓库会拿到下面的freeMarkerConfigure配置
        registry.freeMarker();
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    /**
     * {@link  org.springframework.web.servlet.config.annotation.ViewResolverRegistry.FreeMarkerRegistration}
     * 这个需要在配置一个新的ViewResolver，在上述类中已经新建了一个ViewResolver
     *
     * @return FreeMarker的配置
     */
    @Bean
    public FreeMarkerConfigurer freeMarkerConfigurer() {
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/");
        return freeMarkerConfigurer;
    }

    /**
     * 配置静态资源解析
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
                // 当请求以这个路径开始时
                .addResourceHandler("/resources/**")
                // 请求上个目录下的资源地址，都映射到这个里面
                .addResourceLocations("/WEB-INF/assets")
                // 设置缓存时间
                .setCachePeriod(31556926);
    }
}

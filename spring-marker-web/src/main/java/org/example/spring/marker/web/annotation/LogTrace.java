package org.example.spring.marker.web.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记型注解，在Aspect类中使用
 * Created by lishubin on 2020/8/22 9:55 下午
 * @author lishubin
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface LogTrace {
}

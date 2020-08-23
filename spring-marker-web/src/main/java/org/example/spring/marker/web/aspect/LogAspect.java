package org.example.spring.marker.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 * Created by lishubin on 2020/8/22 9:58 下午
 * @author lishubin
 */
@Aspect
public class LogAspect {

    private static Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Around("@within(org.example.spring.marker.web.annotation.LogTrace)")
    public Object logInfo(ProceedingJoinPoint joinPoint) {
        // 获取方法执行
        Object target = joinPoint.getTarget();
        log.info("执行类 - {}",target.getClass().getName());
        Object[] args = joinPoint.getArgs();
        log.info("方法参数 - {}" , Arrays.toString(args));
        try {
            Object proceedResult = joinPoint.proceed();
            log.info("方法执行结果 - {}",proceedResult);
        } catch (Throwable throwable) {
            log.error("方法执行异常 - {}",throwable.getMessage());
            throwable.printStackTrace();
        }
        return null;
    }


}

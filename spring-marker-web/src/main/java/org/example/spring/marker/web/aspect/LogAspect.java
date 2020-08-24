package org.example.spring.marker.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

/**
 * Created by lishubin on 2020/8/22 9:58 下午
 * @author lishubin
 */
@Aspect
@Component
public class LogAspect {

    private static Logger log = LoggerFactory.getLogger(LogAspect.class);

    @Around("@annotation(org.example.spring.marker.web.annotation.LogTrace)")
    public Object logInfo(ProceedingJoinPoint joinPoint) {


        //1. 获取方法参数类型
        Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getParameterTypes();

        //2. 获取对应的执行类
        String className = joinPoint.getTarget().getClass().getCanonicalName();

        //3. 获取对应执行类的执行方法
        Method method = null;
        try {
            method = joinPoint.getTarget().getClass().getMethod(
                    joinPoint.getSignature().getName(),
                    parameterTypes
            );
        } catch (NoSuchMethodException e) {
            log.error("{} 不存在 {} - {} 方法",
                    className,
                    joinPoint.getSignature().getName(),
                    Arrays.toString(((MethodSignature) joinPoint.getSignature()).getParameterTypes()));
            e.printStackTrace();
        }
        Object proceedResult = null;
        if (Objects.nonNull(method)) {

            log.info("{} - {} 开始执行", className, method.getName());
            long startTime = System.currentTimeMillis();
            try {
                proceedResult = joinPoint.proceed();
                log.info("方法执行结果 - {}", proceedResult);
            } catch (Throwable throwable) {
                log.error("方法执行异常 - {}", throwable.getMessage());
                throwable.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            log.info("{} - {} 执行花费时间:{} ms", className, method.getName(), endTime - startTime);
        }
        return proceedResult;
    }
}

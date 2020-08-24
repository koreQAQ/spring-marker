package org.example.spring.marker.web.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lishubin on 2020/8/23 6:39 下午
 *
 * @author lishubin
 */
@Aspect
@Component
public class RequestCountAspect {

    private static Map<String, Integer> countCache;
    private static Logger logger = LoggerFactory.getLogger(RequestCountAspect.class);

    static {
        // todo 获取所有Controller 的XxxMapping方法
        countCache = new HashMap<>();
    }

    // todo 切点的参数传递
    @Around("execution(* org.example.spring.marker.web.controller.*.*(..))")
    public Object exceptionCount(ProceedingJoinPoint joinPoint) {
        String name = joinPoint.getSignature().getName();
        if (countCache.containsKey(name)) {
            countCache.put(name, countCache.get(name) + 1);
        } else {
            countCache.put(name, 1);
        }
        logger.info("{} - 调用次数 - {}", name, countCache.get(name));
        Object proceedResult = null;
        try {
            proceedResult = joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return proceedResult;
    }
}

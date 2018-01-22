package com.zoro.mail.config.database;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadOnlyConnectionInterceptor implements Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadOnlyConnection.class);

    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {
        LOGGER.info("=================set dataBase connection 2 read only=================");
        try {
            DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            LOGGER.info("=================remove dataBase connection=================");
            DataBaseContextHolder.clearDataBaseType();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
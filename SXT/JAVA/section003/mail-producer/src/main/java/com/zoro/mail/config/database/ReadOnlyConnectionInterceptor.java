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

    private static final Logger logger = LoggerFactory.getLogger(ReadOnlyConnection.class);

    @Around("@annotation(readOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {
        logger.info("=================set dataBase connection 2 read only=================");
        try {
            DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.SLAVE);
            return proceedingJoinPoint.proceed();
        } finally {
            logger.info("=================remove dataBase connection=================");
            DataBaseContextHolder.clearDataBaseType();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
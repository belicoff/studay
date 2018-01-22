/**
 * Copyright: Copyright 2016-2020 JD.COM All Right Reserved
 * FileName: com.zoro.mail.config.database.ReadOnlyConnectionInterceptor
 * Author: zhaoguangfu
 * Department:  企业站
 * Date: 2018/1/22 16:59
 * Description:
 */
package com.zoro.mail.config.database;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;


public class ReadOnlyConnectionInterceptor implements Ordered {

    private static final Logger LOGGER = LoggerFactory.getLogger(ReadOnlyConnection.class);

    @Around("@annotation(ReadOnlyConnection)")
    public Object proceed(ProceedingJoinPoint proceedingJoinPoint, ReadOnlyConnection readOnlyConnection) throws Throwable {
        LOGGER.info("-----------------set dataBase connection 2 read only-----------------");
        try {
            DataBaseContextHolder.setDataBaseType(DataBaseContextHolder.DataBaseType.SLAVE);
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            LOGGER.info("-----------------remove dataBase connection-----------------");
            DataBaseContextHolder.clearDataBaseType();
        }
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
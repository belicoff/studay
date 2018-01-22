package com.zoro.mail.config.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName: ReadOnlyConnection
 * @Description: 动态数据源-数据源标签
 * @author 赵光夫
 * @date 2016-3-29 下午4:52:48
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.TYPE,ElementType.METHOD})
public @interface ReadOnlyConnection {

}
/**
 * Copyright: Copyright 2016-2020 JD.COM All Right Reserved
 * FileName: com.zoro.mail.config.database.DataBaseContextHolder
 * Author: zhaoguangfu
 * Department:  企业站
 * Date: 2018/1/22 15:24
 * Description: 数据库操作选取
 */
package com.zoro.mail.config.database;

/**
 * 数据库操作选取
 * @author zhaoguangfu
 * @create 2018/1/22
 * @since 1.0.0
 */
public class DataBaseContextHolder {

    public enum DataBaseType {
        MASTER, SLAVE
    }

    private static final ThreadLocal<DataBaseType> contextHolder = new ThreadLocal<DataBaseType>();

    public static void setDataBaseType(DataBaseType dataBaseType) {
        if(dataBaseType == null)  throw new NullPointerException();
        contextHolder.set(dataBaseType);
    }

    public static DataBaseType getDataBaseType() {
        return contextHolder.get() == null ? DataBaseType.MASTER : contextHolder.get();
    }

    public static void clearDataBaseType() {
        contextHolder.remove();
    }

}
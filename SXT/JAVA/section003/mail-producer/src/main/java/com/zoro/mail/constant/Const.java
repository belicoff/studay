/**
 * Copyright: Copyright 2016-2020 JD.COM All Right Reserved
 * FileName: com.zoro.mail.constant.Const
 * Author: belicoff
 * Department: 企业站
 * Date: 2018/1/18 0:52
 * Description: 常亮
 */
package com.zoro.mail.constant;

/**
 * 常亮
 * @author belicoff
 * @create 2018/1/18
 * @since 1.0.0
 */
public class Const {

    private Const(){
    }

    public static final String SPRING_PROFILE_DEVELOPMENT = "dev";
    public static final String SPRING_PROFILE_PRODUCTION = "prod";
    public static final String SPRING_PROFILE_LOCATION = "local";

    /** 无关联记录 */
    public static final String NO_PROEING_REF = "0";
    /** 判断代码：是 1 */
    public static final String TRUE = "1";
    /** 判断代码：是 0 */
    public static final String FALSE = "0";
    /** 通用字符集 UTF-8 */
    public static final String CHARSET_UTF8 = "UTF-8";
    /** 中文字符集编码 GBK */
    public static final String CHARSET_CHINESE = "GBK";
    /** 英文字符集编码 ISO-8859-1 */
    public static final String CHARSET_LATIN = "ISO-8859-1";
    /** 根节点ID root */
    public static final String ROOT_ID = "root";
    /** NULL 字符串 */
    public static final String NULL = "null";
    /** 本机地址 localhost */
    public static final String LOCALHOST = "localhost";
    /** 日期格式 yyyy-MM-dd */
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    /** 日期格式-短格式 yyyyMMdd */
    public static final String FORMAT_DATE_SHORT = "yyyyMMdd";
    /** 日期格式 yyyy-MM-dd HH:mm:ss */
    public static final String FORMAT_DATETIME = "yyyy-MM-dd HH:mm:ss";
    /** 日期格式-短格式 yyyyMMddHHmmss */
    public static final String FORMAT_DATETIME_SHORT = "yyyyMMddHHmmss";
    /** 日期格式 yyyy-MM-dd HH:mm:ss.SSS*/
    public static final String FORMAT_TIMESTAMP = "yyyy-MM-dd HH:mm:ss.SSS";
    /** 日期格式-短格式 yyyyMMddHHmmssSSS */
    public static final String FORMAT_TIMESTAMP_SHORT = "yyyyMMddHHmmssSSS";
    /** 成功 */
    public static final String SUCCESS = "success";
    /** 失败 */
    public static final String FAILURE = "failure";
    /** 下划线分割 */
    public static final String UNDERLINE_SPLIT = "_";
    /** 逗号分割 */
    public static final String COMMA_SPLIT = ",";
    /** 操作人：系统（运行时） */
    public static final String SYS_RUNTIME = "SYS_RUNTIME";
    /** 操作人：系统（初始化 */
    public static final String SYS_INIT = "SYS_INIT";

}
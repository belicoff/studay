/**
 * Copyright: Copyright 2016-2020 JD.COM All Right Reserved
 * FileName: com.zoro.mail.utils.KeyUtil
 * Author: belicoff
 * Department: 企业站
 * Date: 2018/1/18 1:08
 * Description: 主键生成策略-工具类
 */
package com.zoro.mail.utils;

import com.fasterxml.uuid.EthernetAddress;
import com.fasterxml.uuid.Generators;
import com.fasterxml.uuid.impl.TimeBasedGenerator;

/**
 * 主键生成策略-工具类
 * @author belicoff
 * @create 2018/1/18
 * @since 1.0.0
 */
public class KeyUtil {

    public static String generatorUUID() {
        TimeBasedGenerator timeBasedGenerator = Generators.timeBasedGenerator(EthernetAddress.fromInterface());
        return timeBasedGenerator.generate().toString();
    }
}
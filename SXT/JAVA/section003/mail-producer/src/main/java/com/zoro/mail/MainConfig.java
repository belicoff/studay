package com.zoro.mail;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 主配置
 * @author belicoff
 * @create 2018/1/18
 * @since 1.0.0
 */
@EnableWebMvc// 启用了spring mvc
@Configuration// 让spring boot 项目启动时识别当前配置类
@ComponentScan({"com.zoro.mail.*"})
@MapperScan(basePackages = "com.zoro.mail.mapper")
public class MainConfig {

}
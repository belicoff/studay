/**
 * Copyright: Copyright 2016-2020 JD.COM All Right Reserved
 * FileName: com.zoro.mail.config.database.DataSourceConfiguration
 * Author: belicoff
 * Department: 企业站
 * Date: 2018/1/18 2:36
 * Description: 配置
 */
package com.zoro.mail.config.database;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@EnableTransactionManagement
public class DataSourceConfiguration {

    private  static Logger logger = LoggerFactory.getLogger(DataSourceConfiguration.class);

    @Value("${druid.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "masterDataSource")
    @Primary
    @ConfigurationProperties(prefix = "druid.master")
    public DataSource masterDataSource() throws SQLException {
        DataSource masterDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        logger.debug("=======================MASTER:{}========================", masterDataSource);
        return masterDataSource;
    }

    @Bean(name = "slaveDataSource")
    @ConfigurationProperties(prefix = "druid.slave")
    public DataSource slaveDataSource() throws SQLException {
        DataSource slaveDataSource = DataSourceBuilder.create().type(dataSourceType).build();
        logger.debug("=======================SLAVE:{}========================", slaveDataSource);
        return slaveDataSource;
    }

    @Bean
    public ServletRegistrationBean druidServlet() {
        ServletRegistrationBean reg = new ServletRegistrationBean();
        reg.setServlet(new StatViewServlet());
//        reg.setAsyncSupported(true);
        reg.addUrlMappings("/druid/*");
        reg.addInitParameter("allow", "localhost");
        reg.addInitParameter("deny", "/deny");
//        reg.addInitParameter("loginUsername", "zoro");
//        reg.addInitParameter("loginPassword", "zoro");
        logger.debug("druid console manager init : {}", reg);
        return reg;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        logger.debug("druid filter register : {} ", filterRegistrationBean);
        return filterRegistrationBean;
    }

}
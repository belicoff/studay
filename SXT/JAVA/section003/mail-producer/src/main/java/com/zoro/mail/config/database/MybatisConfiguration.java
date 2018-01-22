package com.zoro.mail.config.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.aspectj.apache.bcel.util.ClassLoaderRepository;
import org.aspectj.apache.bcel.util.ClassLoaderRepository.SoftHashMap;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 * Mybatis配置管理
 * @author zhaoguangfu
 * @create 2018/1/22
 * @since 1.0.0
 */
@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
public class MybatisConfiguration extends MybatisAutoConfiguration {

    @Resource(name="masterDataSource")
    private DataSource masterDataSource;

    @Resource(name="slaveDataSource")
    private DataSource slaveDataSource;

    @Bean(name="sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        return super.sqlSessionFactory(roundRobinDataSourceProxy());
    }

    public AbstractRoutingDataSource roundRobinDataSourceProxy() {
        ReadWriteSplitRoutingDataSource proxy = new ReadWriteSplitRoutingDataSource();
        SoftHashMap targetDataResource = new ClassLoaderRepository.SoftHashMap();
        targetDataResource.put(DataBaseContextHolder.DataBaseType.MASTER, masterDataSource);
        targetDataResource.put(DataBaseContextHolder.DataBaseType.SLAVE, slaveDataSource);
        proxy.setDefaultTargetDataSource(masterDataSource);
        proxy.setTargetDataSources(targetDataResource);
        return proxy;
    }

}
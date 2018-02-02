package com.zoro.mail.config.database;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.boot.autoconfigure.MybatisAutoConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@AutoConfigureAfter({DataSourceConfiguration.class})
public class MybatisConfiguration extends MybatisAutoConfiguration {

    private static final Logger logger = LoggerFactory.getLogger(MybatisConfiguration.class);

    @Value("${mybatis.type-aliases-package}")
    private String typeAliasesPackage;
    @Value("${mybatis.mapper-locations}")
    private String mapperLocations;

    @Bean(name = "readWriteSplitRoutingDataSource")
    public ReadWriteSplitRoutingDataSource readWriteSplitRoutingDataSource(
            @Qualifier("masterDataSource") DataSource masterDataSource,
            @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        ReadWriteSplitRoutingDataSource readWriteSplitRoutingDataSource = new ReadWriteSplitRoutingDataSource();
        readWriteSplitRoutingDataSource.setDefaultTargetDataSource(masterDataSource);
        Map<Object, Object> map = new HashMap<>();
        map.put(DataBaseContextHolder.DataBaseType.MASTER, masterDataSource);
        map.put(DataBaseContextHolder.DataBaseType.SLAVE, slaveDataSource);
        readWriteSplitRoutingDataSource.setTargetDataSources(map);
        return readWriteSplitRoutingDataSource;
    }



    @Bean("mysqlSqlSessionFactory")
    public SqlSessionFactory mysqlSqlSessionFactory(
            @Qualifier("readWriteSplitRoutingDataSource") ReadWriteSplitRoutingDataSource readWriteSplitRoutingDataSource
    ) throws Exception {
        logger.info(">>>>>>>>>>mysqlSqlSessionFactory初始化=<<<<<<<<<<");
        SqlSessionFactoryBean fb = new SqlSessionFactoryBean();
        fb.setDataSource(readWriteSplitRoutingDataSource);// 指定数据源(这个必须有，否则报错)
        fb.setTypeAliasesPackage(typeAliasesPackage);// 指定基包
        fb.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));//
        return fb.getObject();
    }

}
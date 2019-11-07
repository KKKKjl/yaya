package com.example.app.config;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.IOException;


@Configuration
public class MybatisPlusConfig {

    @Bean
    public ConfigurationCustomizer configurationCustomizer() {
        return configuration -> configuration.setMapUnderscoreToCamelCase(false);
    }

//    @Bean
//    public MybatisSqlSessionFactoryBean mybatisSqlSessionFactoryBean() {
//        MybatisSqlSessionFactoryBean mybatisPlus = new MybatisSqlSessionFactoryBean();
//        mybatisPlus.setDataSource(dataSource);
//        mybatisPlus.setVfs(SpringBootVFS.class);
//        return mybatisPlus;
//    }
}

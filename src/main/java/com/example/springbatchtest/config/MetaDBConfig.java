package com.example.springbatchtest.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class MetaDBConfig {


    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.primary")
    public DataSource metaDBSource(){

        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    public PlatformTransactionManager metaTransactionManager(){
        return new DataSourceTransactionManager(metaDBSource());
    }



}

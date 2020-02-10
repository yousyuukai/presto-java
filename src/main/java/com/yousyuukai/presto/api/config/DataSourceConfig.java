package com.yousyuukai.presto.api.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean(name = "prestoDataSource")
    @ConfigurationProperties(prefix = "presto.datasource")
    public DataSource prestoDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "prestoJdbcTemplate")
    public JdbcTemplate prestoJdbcTemplate(@Qualifier("prestoDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }
}

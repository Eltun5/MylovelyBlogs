package com.Simple_Blog.config;

import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class AppConfig {
    @Value("${db.url}")
    private String url;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Bean
    public DataSource dataSource(){
        PGSimpleDataSource pgSimpleDataSource= new PGSimpleDataSource();
        pgSimpleDataSource.setUrl(url);
        pgSimpleDataSource.setUser(user);
        pgSimpleDataSource.setPassword(password);

        return pgSimpleDataSource;
    }
}


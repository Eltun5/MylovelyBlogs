package com.Simple_Blog.config;

import com.Simple_Blog.simpleDB.DBQueries;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

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
        var DataSource= new DriverManagerDataSource();
        DataSource.setUrl(url);
        DataSource.setUsername(user);
        DataSource.setPassword(password);
        DataSource.setDriverClassName("org.postgresql.Driver");
        return DataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource());
    }

}


package com.Simple_Blog.simpleDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class InitDb {

    @Autowired
    public InitDb(JdbcTemplate jdbcTemplate) {
        try {
            int update = jdbcTemplate.update(DBQueries.CREATE_ALL_TABLES_QUERY);
            if (update==0){
                throw new RuntimeException("Database cannot initialize");
            }
        } catch (Exception e) {
            System.out.println("Bad Code");        }

    }
}

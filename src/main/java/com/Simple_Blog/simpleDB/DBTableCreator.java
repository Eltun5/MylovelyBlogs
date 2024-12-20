package com.Simple_Blog.simpleDB;

import java.sql.SQLException;
import java.sql.Statement;

public class DBTableCreator {
    public static final String CREATE_ALL_TABLES_QUERY ="""
            CREATE TABLE if not exists Users (
                  id SERIAL PRIMARY KEY,
                  username VARCHAR(50) NOT NULL UNIQUE,
                  email VARCHAR(100) NOT NULL UNIQUE,
                  password VARCHAR(255) NOT NULL,
                  role VARCHAR(10) CHECK (role IN ('admin', 'author', 'reader')) DEFAULT 'reader',
                  created_at DATE DEFAULT CURRENT_DATE
              );
              
              CREATE TABLE if not exists Posts (
                  id SERIAL PRIMARY KEY,
                  title VARCHAR(255) NOT NULL,
                  content TEXT NOT NULL,
                  author_id INT NOT NULL,
                  created_at DATE DEFAULT CURRENT_DATE,
                  updated_at DATE DEFAULT CURRENT_DATE,
                  status VARCHAR(10) CHECK (status IN ('published', 'draft')) DEFAULT 'draft',
                  FOREIGN KEY (author_id) REFERENCES Users(id) ON DELETE CASCADE
              );
              
              CREATE TABLE if not exists Comments (
                  id SERIAL PRIMARY KEY,
                  post_id INT NOT NULL,
                  user_id INT NOT NULL,
                  content TEXT NOT NULL,
                  created_at DATE DEFAULT CURRENT_DATE,
                  FOREIGN KEY (post_id) REFERENCES Posts(id) ON DELETE CASCADE,
                  FOREIGN KEY (user_id) REFERENCES Users(id) ON DELETE CASCADE
              );
            """;
}

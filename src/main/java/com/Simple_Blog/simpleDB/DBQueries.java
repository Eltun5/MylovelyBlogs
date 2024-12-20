package com.Simple_Blog.simpleDB;

public class DBQueries {
    public static final String CREATE_ALL_TABLES_QUERY ="""
            DO $$
                BEGIN
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'blog_status') THEN
                        CREATE TYPE blog_status as ENUM ('PUBLISHED','DRAFT','DELETED');
                    END IF;
                END $$;
            DO $$
                BEGIN
                    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'blog_status') THEN
                        CREATE TYPE author_status as ENUM ('ADMIN','AUTHOR','READER');
                    END IF;
                END $$;
            
            CREATE TABLE if not exists authors (
                  id SERIAL PRIMARY KEY,
                  username VARCHAR(50) NOT NULL UNIQUE,
                  email VARCHAR(100) NOT NULL UNIQUE,
                  password VARCHAR(255) NOT NULL,
                  role author_status DEFAULT 'READER' NOT NULL,
                  created_at TIMESTAMP DEFAULT now()
              );
              
              CREATE TABLE if not exists blogs (
                  id SERIAL PRIMARY KEY,
                  title VARCHAR(255) NOT NULL,
                  content TEXT NOT NULL,
                  author_id INT NOT NULL,
                  created_at TIMESTAMP DEFAULT now(),
                  updated_at TIMESTAMP DEFAULT now(),
                  status blog_status DEFAULT 'DRAFT' NOT NULL,
                  FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
              );
              
              CREATE TABLE if not exists comments (
                  id SERIAL PRIMARY KEY,
                  blog_id INT NOT NULL,
                  author_id INT NOT NULL,
                  content TEXT NOT NULL,
                  created_at TIMESTAMP DEFAULT now(),
                  FOREIGN KEY (blog_id) REFERENCES blogs(id) ON DELETE CASCADE,
                  FOREIGN KEY (author_id) REFERENCES authors(id) ON DELETE CASCADE
              );
              CREATE TABLE if not exists tags (
                  id SERIAL PRIMARY KEY,
                  name VARCHAR(50) NOT NULL UNIQUE
              );
              
              CREATE TABLE if not exists post_tags (
                  id SERIAL PRIMARY KEY,
                  blog_id INT NOT NULL,
                  tag_id INT NOT NULL,
                  FOREIGN KEY (blog_id) REFERENCES blogs(id) ON DELETE CASCADE,
                  FOREIGN KEY (tag_id) REFERENCES tags(id) ON DELETE CASCADE
              );
            """;
    public static final String GET_ALL_AUTHORS_QUERY= """
            select id, username , email , role , created_at from authors;
            """;
    public static final String GET_AUTHOR_FOR_LOGIN_QUERY= """
            select id, username , password  from authors;
            """;
    public static final String GET_AUTHOR_BY_ID_QUERY= """
            select id, username , email , role , created_at from authors;
            """;
}

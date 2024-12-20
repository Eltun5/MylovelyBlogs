package com.Simple_Blog.model;

import com.Simple_Blog.enums.BlogType;

import java.time.LocalDateTime;

public record Blog(Integer id , String title , String content , Integer author_id,
                   LocalDateTime created_at , LocalDateTime updated_at , BlogType status) {
}

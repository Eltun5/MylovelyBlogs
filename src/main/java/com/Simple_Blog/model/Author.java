package com.Simple_Blog.model;

import com.Simple_Blog.enums.AuthorType;

import java.time.LocalDateTime;

public record Author(Integer id, String username , String email ,
                     String password , AuthorType role , LocalDateTime created_at ) {
}

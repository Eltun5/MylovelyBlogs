package com.Simple_Blog.models;

import com.Simple_Blog.enums.UserTypes;

import java.time.LocalDate;

public record User(Integer id, String username , String email ,
                   String password , UserTypes role , LocalDate created_at ) {
}

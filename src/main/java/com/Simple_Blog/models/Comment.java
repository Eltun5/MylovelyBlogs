package com.Simple_Blog.models;

import java.time.LocalDate;

public record Comment(Integer id , Integer post_id , Integer user_id ,
                      String content , LocalDate created_at) {
}

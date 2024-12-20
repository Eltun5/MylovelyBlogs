package com.Simple_Blog.models;

import com.Simple_Blog.enums.PostTypes;

import java.time.LocalDate;

public record Post (Integer id , String title , String content , Integer author_id,
                    LocalDate created_at , LocalDate updated_at , PostTypes status){
}

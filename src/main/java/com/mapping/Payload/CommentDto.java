package com.mapping.Payload;

import com.mapping.entity.Post;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class CommentDto {

    private String email;
    private String comment;
    private Post post;

}
package com.mapping.Payload;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class PostDto {

    private String title;
    private String description;

}
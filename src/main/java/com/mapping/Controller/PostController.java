package com.mapping.Controller;

import com.mapping.Payload.PostDto;
import com.mapping.Service.PostService;
import com.mapping.entity.Post;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    private PostService postService;

    public PostController(PostService postService){
        this.postService=postService;
    }

    @PostMapping("/Create")
    public ResponseEntity<PostDto> addPost(@RequestBody PostDto postDto){
        PostDto pDto = postService.createPost(postDto);
        return new ResponseEntity<>(pDto, HttpStatus.CREATED);
    }
}

package com.mapping.Controller;

import com.mapping.Payload.CommentDto;
import com.mapping.Service.CommentService;
import com.mapping.Service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {

    private CommentService commentService;

    public CommentController(CommentService commentService){
        this.commentService = commentService;

    }

    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestBody CommentDto commentDto, @RequestParam long postId){
        CommentDto dto = commentService.addComment(commentDto,postId);
        return new ResponseEntity<>(dto, HttpStatus.CREATED);

    }
}

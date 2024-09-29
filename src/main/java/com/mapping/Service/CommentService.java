package com.mapping.Service;

import com.mapping.Payload.CommentDto;

public interface CommentService {
    CommentDto addComment(CommentDto commentDto, long postId);
}

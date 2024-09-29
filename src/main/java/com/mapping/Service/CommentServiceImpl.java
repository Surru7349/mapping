package com.mapping.Service;

import com.mapping.Payload.CommentDto;
import com.mapping.Repository.CommentRepository;
import com.mapping.Repository.PostRepository;
import com.mapping.entity.Comment;
import com.mapping.entity.Post;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository){
       this.postRepository = postRepository;
       this.commentRepository= commentRepository;
    }
    @Override
    public CommentDto addComment(CommentDto commentDto, long postId) {
        Post post= postRepository.findById(postId).get();
        Comment  comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDto dto = mapToDto(savedComment);
        return dto;
    }

    private Comment mapToEntity(CommentDto commentDto) {
            Comment com = new Comment();
            com.setEmail(com.getEmail());
            com.setComment(commentDto.getComment());
            return com;

    }

    private CommentDto mapToDto(Comment savedComment) {
        CommentDto cDto = new CommentDto();
        cDto.setEmail(savedComment.getEmail());
        cDto.setComment(savedComment.getComment());
        cDto.setPost(savedComment.getPost());
        return cDto;
    }


}

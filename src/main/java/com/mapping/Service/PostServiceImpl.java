package com.mapping.Service;

import com.mapping.Payload.PostDto;
import com.mapping.Repository.PostRepository;
import com.mapping.entity.Post;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository){
        this.postRepository=postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedEntity = postRepository.save(post);
        PostDto dto = mapToDto(savedEntity);
        return dto;

    }

    private PostDto mapToDto(Post p) {
        PostDto dto = new PostDto();
        dto.setTitle(p.getTitle());
        dto.setDescription(p.getDescription());
        return dto;
    }

    private Post mapToEntity(PostDto postDto) {
        Post p = new Post();
        p.setTitle(postDto.getTitle());
        p.setDescription(postDto.getDescription());
        return p;
    }
}

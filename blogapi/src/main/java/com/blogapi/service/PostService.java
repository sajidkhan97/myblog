package com.blogapi.service;

import com.blogapi.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto);



    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);




    PostDto getPostById(long id);



    PostDto updatePost(PostDto postDto, long id);



    void deletePostById(long id);


}

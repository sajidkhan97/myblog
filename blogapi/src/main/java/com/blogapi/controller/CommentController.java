package com.blogapi.controller;

import com.blogapi.payload.CommentDto;
import com.blogapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class CommentController {
    private CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<CommentDto> createComment(@PathVariable(value = "postId") long postId, @RequestBody CommentDto commentDto){
        return new ResponseEntity<>(commentService.createComment(postId, commentDto), HttpStatus.CREATED);

    }
    @GetMapping("/posts/{postId}/comments")
    public List<CommentDto> getCommentsByPostId(@PathVariable(value = "postId") long postId){
        return commentService.getCommentsByPostId(postId);

    }
    @GetMapping("/posts/{postId}/comments/{id}")

    public ResponseEntity<CommentDto> getCommentById(@PathVariable(value = "postId") long postId,
                                                     @PathVariable(value = "id") long id){
        CommentDto commentDto = commentService.getCommentById(postId, id);
        return new ResponseEntity<>(commentDto, HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}/comments/{id}")

    public ResponseEntity<CommentDto> updateComment(@PathVariable(value = "postId") long postId,
                                                    @PathVariable(value = "id") long id,
                                                    @RequestBody CommentDto commentDto){
        CommentDto updatedComment = commentService.updateComment(postId, id, commentDto);
        return new ResponseEntity<>(updatedComment, HttpStatus.OK);

    }

    @DeleteMapping("/posts/{postId}/comments/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable(value = "postId") long postId,
                                                @PathVariable(value = "id") long id){
        commentService.deleteById(postId,id);
        return new ResponseEntity<>("Comment have been deleted successfully",HttpStatus.OK);
    }
}

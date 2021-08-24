package dev.valhalla.backend.controllers;

import dev.valhalla.backend.models.Comment;
import dev.valhalla.backend.models.Post;
import dev.valhalla.backend.services.CommentService;
import dev.valhalla.backend.services.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;
    private final CommentService commentService;

    @GetMapping
    public ResponseEntity get(){
        return ResponseEntity.ok(postService.getAll());
    }

    @GetMapping("/{post_id}/comments")
    public ResponseEntity getComments(@PathVariable("post_id") Long postId){
        return ResponseEntity.ok(postService.getAllComments(postId));
    }

    @PostMapping("/{post_id}/comments")
    public ResponseEntity saveComment(@PathVariable("post_id") Long postId, @RequestBody Comment comment){
        comment.setPost(postService.get(postId));
        return ResponseEntity.ok(commentService.save(comment));
    }

    @PostMapping
    public ResponseEntity save(@RequestBody Post post){
        return ResponseEntity.ok(postService.save(post));
    }

}

package dev.valhalla.backend.services;

import dev.valhalla.backend.models.Comment;
import dev.valhalla.backend.models.Post;
import dev.valhalla.backend.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final CommentService commentService;
    private final UserService userService;

    public Iterable<Post> getAll(){
        return postRepository.findAll();
    }

    public Post get(Long postId) {
        return postRepository.getById(postId);
    }
    public Post save(Post post) {
        post.setUser(userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        return postRepository.save(post);
    }

    public List<Comment> getAllComments(Long postId) {
        return commentService.getAllByPost(postRepository.getById(postId));
    }
}

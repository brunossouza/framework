package dev.valhalla.backend.services;

import dev.valhalla.backend.models.Comment;
import dev.valhalla.backend.models.Post;
import dev.valhalla.backend.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserService userService;

    public List<Comment> getAllByPost(Post post){
        return commentRepository.findAllByPost(post);
    }


    public Comment save(Comment comment) {
        comment.setUser(userService.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName()));
        return commentRepository.save(comment);
    }
}

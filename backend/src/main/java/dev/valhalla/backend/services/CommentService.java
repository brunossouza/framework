package dev.valhalla.backend.services;

import dev.valhalla.backend.models.Comment;
import dev.valhalla.backend.models.Post;
import dev.valhalla.backend.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> getAllByPost(Post post){
        return commentRepository.findAllByPost(post);
    }


    public Comment save(Comment comment) {
        return commentRepository.save(comment);
    }
}

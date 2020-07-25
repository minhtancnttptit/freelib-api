package com.newptit.freelib.controller;

import com.newptit.freelib.model.Comment;
import com.newptit.freelib.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "https://freelib.vercel.app/", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class CommentController {
    @Autowired
    private CommentRepository commentRepository;

    @GetMapping("/commment")
    public ResponseEntity getComments(@RequestParam(required = false) String idResource) {
        List<Comment> comments = commentRepository.getCommentsByIdresource(idResource);
        if (comments.isEmpty()) {
            return new ResponseEntity(comments, HttpStatus.OK);
        }
        return new ResponseEntity(comments, HttpStatus.OK);
    }

    @PostMapping("/comment")
    public ResponseEntity addComment(@RequestBody Comment comment) {
        Comment saved = commentRepository.save(comment);
        if (saved != null) {
            return new ResponseEntity(saved, HttpStatus.OK);
        }
        return new ResponseEntity(null, HttpStatus.NOT_FOUND);
    }
}

package com.newptit.freelib.repository;

import com.newptit.freelib.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, String> {
    public List<Comment> getCommentsByIdresource(String id);
}

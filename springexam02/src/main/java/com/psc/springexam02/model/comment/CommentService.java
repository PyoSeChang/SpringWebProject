package com.psc.springexam02.model.comment;

import com.psc.springexam02.dto.CommentDTO;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CommentService implements CommentServiceInterface {
    private final CommentDAO commentDAO;
    @Override
    public void insertComment(CommentDTO comment) {
        commentDAO.dao_insertComment(comment);
    }

    @Override
    public void updateComment(CommentDTO comment) {

    }

    @Override
    public void deleteComment(CommentDTO comment) {

    }

    @Override
    public List<CommentDTO> showComments() {
        return List.of();
    }
}

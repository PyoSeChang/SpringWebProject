package com.psc.springexam02.model.comment;

import com.psc.springexam02.dto.CommentDTO;
import com.psc.springexam02.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class CommentDAO implements CommentRepository {
    private final CommentMapper commentMapper;
    @Override
    public void dao_insertComment(CommentDTO comment) {
        commentMapper.insertComment(comment);
    }

    @Override
    public void dao_updateComment(CommentDTO comment) {

    }

    @Override
    public void dao_deleteComment(CommentDTO comment) {

    }

    @Override
    public List<CommentDTO> dao_showComments() {
        return List.of();
    }
}

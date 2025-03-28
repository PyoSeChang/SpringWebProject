package com.psc.springexam02.model.comment;

import com.psc.springexam02.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class CommentService implements CommentServiceInterface {
    private final CommentDAO commentDAO;
    @Override
    public void insertComment(CommentDTO comment) {
        commentDAO.dao_insertComment(comment);
    }

    @Override
    public void updateComment(CommentDTO comment) {
        commentDAO.dao_updateComment(comment);
    }

    @Override
    public void deleteComment(int cnum) {
        commentDAO.dao_deleteComment(cnum);
    }

    @Override
    public List<CommentDTO> showComments(int num) {
        return commentDAO.dao_showComments(num);
    }

    @Override // 댓글 하나 출력
    public CommentDTO showComment(int cnum) {
        return commentDAO.dao_showComment(cnum);
    }
}

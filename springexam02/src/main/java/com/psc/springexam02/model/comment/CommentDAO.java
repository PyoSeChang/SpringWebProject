package com.psc.springexam02.model.comment;

import com.psc.springexam02.dto.CommentDTO;
import com.psc.springexam02.mapper.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
@Repository
public class CommentDAO implements CommentRepository {
    private final CommentMapper commentMapper;
    @Override
    public void dao_insertComment(CommentDTO comment) {
        commentMapper.insertComment(comment);
    }

    @Override
    public void dao_updateComment(CommentDTO comment) {
        commentMapper.updateComment(comment);
    }

    @Override
    public void dao_deleteComment(int cnum) {
        commentMapper.deleteComment(cnum);
    }

    @Override
    public List<CommentDTO> dao_showComments(int num) {
        return commentMapper.showComments(num);
    }
    // 댓글 하나 출력
    @Override
    public CommentDTO dao_showComment(int cnum) {
        return commentMapper.showComment(cnum);
    }

    @Override
    public void dao_deleteAllComments(int num) {
        commentMapper.deleteAllComments(num);
    }

    @Override
    public void dao_updateCommentCount(int cnum, boolean flag) {
        int amount;
        if (flag==true) {
            commentMapper.updateCommentCount(cnum,1);
        } else {
            commentMapper.updateCommentCount(cnum,-1);
        }
    }
}

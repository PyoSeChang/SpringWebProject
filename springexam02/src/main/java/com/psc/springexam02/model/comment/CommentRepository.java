package com.psc.springexam02.model.comment;

import com.psc.springexam02.dto.CommentDTO;

import java.util.List;

public interface CommentRepository {

    // 추가
    void dao_insertComment(CommentDTO comment);
    // 수정
    void dao_updateComment(CommentDTO comment);
    // 삭제
    void dao_deleteComment(CommentDTO comment);
    // 출력
    List<CommentDTO> dao_showComments();
}

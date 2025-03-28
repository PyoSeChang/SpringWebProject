package com.psc.springexam02.model.comment;

import com.psc.springexam02.dto.CommentDTO;

import java.util.List;

public interface CommentServiceInterface {
    // 추가
    void insertComment(CommentDTO comment);
    // 수정
    void updateComment(CommentDTO comment);
    // 삭제
    void deleteComment(CommentDTO comment);
    // 출력
    List<CommentDTO> showComments();
}

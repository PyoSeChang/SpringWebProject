package com.psc.springexam02.mapper;

import com.psc.springexam02.dto.CommentDTO;

import java.util.List;

public interface CommentMapper {
    // 댓글 추가
    void insertComment(CommentDTO comment);
    // 댓글 수정
    void updateComment(CommentDTO comment);
    // 댓글 삭제
    void deleteComment(CommentDTO comment);
    // 댓글 불러오기
    List<CommentDTO> showComments();
}

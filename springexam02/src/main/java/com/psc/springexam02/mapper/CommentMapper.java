package com.psc.springexam02.mapper;

import com.psc.springexam02.dto.CommentDTO;

import java.util.List;

public interface CommentMapper {
    // 댓글 추가
    void insertComment(CommentDTO comment);
    // 댓글 수정
    void updateComment(CommentDTO comment);
    // 댓글 삭제
    void deleteComment(int cnum);
    // 댓글 불러오기
    List<CommentDTO> showComments(int num);
    // 댓글 하나 출력
    CommentDTO showComment(int cnum);
}

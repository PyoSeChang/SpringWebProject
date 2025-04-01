package com.psc.springexam02.model.comment;

import com.psc.springexam02.dto.CommentDTO;

import java.util.List;

public interface CommentServiceInterface {
    // 추가
    void insertComment(CommentDTO comment);
    // 수정
    void updateComment(CommentDTO comment);
    // 삭제
    void deleteComment(int cnum);
    // 출력
    List<CommentDTO> showComments(int num);
    // 댓글 하나 출력
    CommentDTO showComment(int cnum);
    // 댓글 모두 삭제
    void deleteAllComments(int num);
    // 댓글 count
    void increaseCommentCount(int cnum);
    void decreaseCommentCount(int cnum);
}


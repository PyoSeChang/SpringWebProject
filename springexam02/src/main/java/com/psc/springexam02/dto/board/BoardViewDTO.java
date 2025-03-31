package com.psc.springexam02.dto.board;


import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BoardViewDTO {
    // 본문 정보
    private int num;
    private String userid;
    private String subject;
    private String content;
    private String password;

    // 메타 정보
    private String category;
    private List<String> tags;
    private Timestamp regdate;
    private Timestamp updatedate;

    // 상태 정보
    private int readcount;
    private int likecount;
    private int dislikecount;
    private int commentcount;
}

package com.psc.springexam02.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class CommentDTO {
    private int cnum;
    private int bnum;
    private String userid;
    private String message;
    private String regdate;
    private String password;
    private Timestamp updatedate;
}

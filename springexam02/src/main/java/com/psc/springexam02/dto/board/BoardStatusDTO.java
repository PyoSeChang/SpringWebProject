package com.psc.springexam02.dto.board;

import lombok.Data;

@Data
public class BoardStatusDTO {
    private int num;
    private int readcount;
    private int likecount;
    private int dislikecount;
    private int commentcount;
}

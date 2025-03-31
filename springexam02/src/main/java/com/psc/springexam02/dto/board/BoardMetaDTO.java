package com.psc.springexam02.dto.board;

import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

@Data
public class BoardMetaDTO {
    private int num;
    private String category;
    private List<String> tags;
    private Timestamp regdate;
    private Timestamp updatedate;

}

package com.psc.springexam02.dto.board;

import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

@Getter
@Setter
public class BoardDTO {
	private int num;
	private String userid;
	private String subject;
	private String content;
	private String regdate;
	private String password;
	private Timestamp updatedate;
}

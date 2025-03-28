package com.psc.springexam02.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDTO {
	private int num;
	private String userid;
	private String subject;
	private String content;
	private String regdate;

}

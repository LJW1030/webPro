package com.lec.ch17.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class board {
	private int bid;
	private String bname;
	private String btitle;
	private String bcontent;
	private Date bdate;
	private int bhit;
	private int bgroup;
	private int bstep;
	private int bindent;
	private String bip;
	private int startRow; // 페이징처리를 위한 속성변수
	private int endRow;   // 페이징처리를 위한 속성변수
}

package com.example.spring01.domain;


import java.sql.Timestamp;
import java.util.Date;

public class AccountVO {

	/*
	 * 장바구니번호
	 * 사용자 아이디
	 * 사용자 이름
	 * 비디오 번호
	 * 영화명
	 * 요금
	 * */
	
	private int ano;				//장바구니 번호
	private String vno;				// 비디오 번호
	private String movie;			// 영화명
	private String userId;			// 사용자 아이디
	private Timestamp rentdate;			// 대여일
	private Date returndate;		// 반납일
	private int state;				// 수량
	private int price;				// 상품 가격
	
	

	
	
	
}

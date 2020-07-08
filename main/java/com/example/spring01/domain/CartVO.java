package com.example.spring01.domain;


import java.sql.Timestamp;
import java.util.Date;

public class CartVO {

	/*
	 * 장바구니번호
	 * 사용자 아이디
	 * 사용자 이름
	 * 비디오 번호
	 * 영화명
	 * 요금
	 * */
	
	private int rno;				//장바구니 번호
	
	public Date getRentdate() {
		return rentdate;
	}
	public void setRentdate(Date rentdate) {
		this.rentdate = rentdate;
	}
	private String vno;				// 비디오 번호
	private String movie;			// 영화명
	private String userId;			// 사용자 아이디
	private Date rentdate;			// 대여일

	private Date returndate;		// 반납일
	private int state;				// 수량
	private int price;				// 상품 가격
	private int totalprice;
	
	private int sumprice;			// 가격 총합
	private int sumstate;			// 총개수
	
	private String month;			//정산관리 월
	private String year;			//정산관리 년
	
	

	
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	
	
	public int getSumstate() {
		return sumstate;
	}
	public void setSumstate(int sumstate) {
		this.sumstate = sumstate;
	}
	
	
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}

	
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public int getSumprice() {
		return sumprice;
	}
	public void setSumprice(int sumprice) {
		this.sumprice = sumprice;
	}
	
	
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	public Date getReturndate() {
		return returndate;
	}
	public void setReturndate(Date returndate) {
		this.returndate = returndate;
	}

	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getVno() {
		return vno;
	}
	public void setVno(String vno) {
		this.vno = vno;
	}
	public String getMovie() {
		return movie;
	}
	public void setMovie(String movie) {
		this.movie = movie;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	

	
	
	
}

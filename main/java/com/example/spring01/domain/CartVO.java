package com.example.spring01.domain;


import java.sql.Timestamp;
import java.util.Date;

public class CartVO {

	/*
	 * ��ٱ��Ϲ�ȣ
	 * ����� ���̵�
	 * ����� �̸�
	 * ���� ��ȣ
	 * ��ȭ��
	 * ���
	 * */
	
	private int rno;				//��ٱ��� ��ȣ
	
	public Date getRentdate() {
		return rentdate;
	}
	public void setRentdate(Date rentdate) {
		this.rentdate = rentdate;
	}
	private String vno;				// ���� ��ȣ
	private String movie;			// ��ȭ��
	private String userId;			// ����� ���̵�
	private Date rentdate;			// �뿩��

	private Date returndate;		// �ݳ���
	private int state;				// ����
	private int price;				// ��ǰ ����
	private int totalprice;
	
	private int sumprice;			// ���� ����
	private int sumstate;			// �Ѱ���
	
	private String month;			//������� ��
	private String year;			//������� ��
	
	

	
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

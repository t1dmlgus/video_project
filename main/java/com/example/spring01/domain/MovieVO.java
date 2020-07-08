package com.example.spring01.domain;

import java.sql.Date;

public class MovieVO {

	/*															movie + video (dto)
	 	create table movie(
		mno varchar(50) primary key,
		movie varchar(50),
		runningtime varchar(50),
		releaseday date,
		nation varchar(50),
		grade_gno int,
		foreign key (grade_gno) references grade (gno));
	 */
	
	
	private String vno;
	private String mno;
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		this.mno = mno;
	}
	private String movie;
	private int runningtime;
	private Date releaseday;
	private String nation;
	private String genre;
	private String grade;
	private String state;
	private int video_price;
	
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getVideo_price() {
		return video_price;
	}
	public void setVideo_price(int video_price) {
		this.video_price = video_price;
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
	public int getRunningtime() {
		return runningtime;
	}
	public void setRunningtime(int runningtime) {
		this.runningtime = runningtime;
	}
	public Date getReleaseday() {
		return releaseday;
	}
	public void setReleaseday(Date releaseday) {
		this.releaseday = releaseday;
	}
	public String getNation() {
		return nation;
	}
	public void setNation(String nation) {
		this.nation = nation;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
}

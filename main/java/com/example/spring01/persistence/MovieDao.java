package com.example.spring01.persistence;

import java.util.List;

import javax.servlet.http.HttpSession;


import com.example.spring01.domain.MovieVO;




public interface MovieDao {
	
	
	
	//01. 영화목록
	public List<MovieVO> movieList(String searchOption, String keyword) throws Exception;
	
	//01. 영화 상세정보(리스트)
	public List<MovieVO> view2Movie(String mno);
	
	//02. 영화 상세정보(단일)
	public MovieVO select2Movie(String mno);
	
	
	
	//01. 비디오목록(수정)
	public List<MovieVO> listAll(String searchOption, String keyword) throws Exception;
	
	//03. 영화 등록
	public void insertMovie(MovieVO vo);
	
	//04. 비디오 등록
	public void insertVideo(MovieVO vo);
	
	
	// 영화 상세조회
	public MovieVO viewMovie(String vno);
	
	// 영화 삭제
	public void deleteMovie(MovieVO vo);
	
	// 영화 수정
	public void updateMovie(MovieVO vo);
	
	
	// 07. 게시글 레코드 개수 메서드 
	public int countArticle(String searchOption, String keyword) throws Exception;
		
	

}

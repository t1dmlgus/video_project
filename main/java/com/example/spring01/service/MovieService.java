package com.example.spring01.service;

import java.util.List;

import javax.servlet.http.HttpSession;


import com.example.spring01.domain.MovieVO;




public interface MovieService {
	//01.  영화 목록 서비스(검색)
	public List<MovieVO> movieList(String searchOption, String keyword) throws Exception;
	
	//01. 영화 상세조회 서비스(리스트)
	public List<MovieVO> view2Movie(String mno);
	
	//01. 영화 상세조회 서비스(단일)
	public MovieVO select2Movie(String mno);
	
	
	
	//02. 영화 수정 서비스 
	public void updateMovie(MovieVO vo);
	
	// 영화 삭제 서비스
	public void deleteMovie(MovieVO vo);
	
	
	// 02. 비디오 목록(검색)//  리스트형으로 각 BoardVo 객체
	//public List<BoardVo> listAll() throws Exception;
	public List<MovieVO> listAll(String searchOption, String keyword) throws Exception;
	
	
	// 03.영화 등록 서비스
	public void insertMovie(MovieVO vo);
	
	// 04.비디오 등록 서비스
	public void insertVideo(MovieVO vo);

	
	
	
	
	//02. 비디오 상세조회 서비스
	public MovieVO viewMovie(String vno);
	
	// 영화 삭제 서비스

	


	// 영화 검색 개수 
	int countArticle(String searchOption, String keyword) throws Exception;

	
	

}

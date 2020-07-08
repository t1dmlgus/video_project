package com.example.spring01.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;


import com.example.spring01.domain.MovieVO;
import com.example.spring01.persistence.MovieDaoImpl;

@Repository
public class MovieServiceImpl implements MovieService{

	@Inject
	MovieDaoImpl movieDao;
	
	
	//  01. 영화 목록 서비스 (검색)
	@Override
	public List<MovieVO> movieList(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return movieDao.movieList(searchOption, keyword);
	}
	
	// 01. 영화 상세정보 서비스(리스트)
	@Override
	public List<MovieVO> view2Movie(String mno) {
		// TODO Auto-generated method stub
		return movieDao.view2Movie(mno);
	}
	
	
	//01. 영화 상세정보 서비스(단일)
	@Override
	public MovieVO select2Movie(String mno) {
		// TODO Auto-generated method stub
		return movieDao.select2Movie(mno);
	}

	
	
	
	
	
	
	
//  01. 비디오 목록 서비스(검색)
	@Override
	public List<MovieVO> listAll(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		return movieDao.listAll(searchOption, keyword);
	}
	
	
	//03. 영화 등록 서비스
	@Override
	public void insertMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		movieDao.insertMovie(vo);
	}
	

	//04. 비디오 등록 서비스
	@Override
	public void insertVideo(MovieVO vo) {
		// TODO Auto-generated method stub
		
		movieDao.insertVideo(vo);
		
	}
	
	
	
	
	//02. 영화 상세조회 서비스
	@Override
	public MovieVO viewMovie(String vno) {
		// TODO Auto-generated method stub
		return movieDao.viewMovie(vno);
	}
	
	
	
	
	// 영화 삭제 서비스
	@Override
	public void deleteMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		movieDao.deleteMovie(vo);
	}
	
	// 영화 수정 서비스 
	@Override
	public void updateMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		movieDao.updateMovie(vo);
	}

	
	
	
	
	
	//07. 게시글 레코드 갯수 메서드
		@Override
		public int countArticle(String searchOption, String keyword) throws Exception {
			// TODO Auto-generated method stub
			return movieDao.countArticle(searchOption, keyword);
		}


	

		
	
	
}

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
	
	
	//  01. ��ȭ ��� ���� (�˻�)
	@Override
	public List<MovieVO> movieList(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return movieDao.movieList(searchOption, keyword);
	}
	
	// 01. ��ȭ ������ ����(����Ʈ)
	@Override
	public List<MovieVO> view2Movie(String mno) {
		// TODO Auto-generated method stub
		return movieDao.view2Movie(mno);
	}
	
	
	//01. ��ȭ ������ ����(����)
	@Override
	public MovieVO select2Movie(String mno) {
		// TODO Auto-generated method stub
		return movieDao.select2Movie(mno);
	}

	
	
	
	
	
	
	
//  01. ���� ��� ����(�˻�)
	@Override
	public List<MovieVO> listAll(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		
		
		
		
		return movieDao.listAll(searchOption, keyword);
	}
	
	
	//03. ��ȭ ��� ����
	@Override
	public void insertMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		movieDao.insertMovie(vo);
	}
	

	//04. ���� ��� ����
	@Override
	public void insertVideo(MovieVO vo) {
		// TODO Auto-generated method stub
		
		movieDao.insertVideo(vo);
		
	}
	
	
	
	
	//02. ��ȭ ����ȸ ����
	@Override
	public MovieVO viewMovie(String vno) {
		// TODO Auto-generated method stub
		return movieDao.viewMovie(vno);
	}
	
	
	
	
	// ��ȭ ���� ����
	@Override
	public void deleteMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		movieDao.deleteMovie(vo);
	}
	
	// ��ȭ ���� ���� 
	@Override
	public void updateMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		movieDao.updateMovie(vo);
	}

	
	
	
	
	
	//07. �Խñ� ���ڵ� ���� �޼���
		@Override
		public int countArticle(String searchOption, String keyword) throws Exception {
			// TODO Auto-generated method stub
			return movieDao.countArticle(searchOption, keyword);
		}


	

		
	
	
}

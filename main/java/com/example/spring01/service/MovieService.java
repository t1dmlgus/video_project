package com.example.spring01.service;

import java.util.List;

import javax.servlet.http.HttpSession;


import com.example.spring01.domain.MovieVO;




public interface MovieService {
	//01.  ��ȭ ��� ����(�˻�)
	public List<MovieVO> movieList(String searchOption, String keyword) throws Exception;
	
	//01. ��ȭ ����ȸ ����(����Ʈ)
	public List<MovieVO> view2Movie(String mno);
	
	//01. ��ȭ ����ȸ ����(����)
	public MovieVO select2Movie(String mno);
	
	
	
	//02. ��ȭ ���� ���� 
	public void updateMovie(MovieVO vo);
	
	// ��ȭ ���� ����
	public void deleteMovie(MovieVO vo);
	
	
	// 02. ���� ���(�˻�)//  ����Ʈ������ �� BoardVo ��ü
	//public List<BoardVo> listAll() throws Exception;
	public List<MovieVO> listAll(String searchOption, String keyword) throws Exception;
	
	
	// 03.��ȭ ��� ����
	public void insertMovie(MovieVO vo);
	
	// 04.���� ��� ����
	public void insertVideo(MovieVO vo);

	
	
	
	
	//02. ���� ����ȸ ����
	public MovieVO viewMovie(String vno);
	
	// ��ȭ ���� ����

	


	// ��ȭ �˻� ���� 
	int countArticle(String searchOption, String keyword) throws Exception;

	
	

}

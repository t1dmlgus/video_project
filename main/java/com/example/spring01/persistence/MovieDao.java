package com.example.spring01.persistence;

import java.util.List;

import javax.servlet.http.HttpSession;


import com.example.spring01.domain.MovieVO;




public interface MovieDao {
	
	
	
	//01. ��ȭ���
	public List<MovieVO> movieList(String searchOption, String keyword) throws Exception;
	
	//01. ��ȭ ������(����Ʈ)
	public List<MovieVO> view2Movie(String mno);
	
	//02. ��ȭ ������(����)
	public MovieVO select2Movie(String mno);
	
	
	
	//01. �������(����)
	public List<MovieVO> listAll(String searchOption, String keyword) throws Exception;
	
	//03. ��ȭ ���
	public void insertMovie(MovieVO vo);
	
	//04. ���� ���
	public void insertVideo(MovieVO vo);
	
	
	// ��ȭ ����ȸ
	public MovieVO viewMovie(String vno);
	
	// ��ȭ ����
	public void deleteMovie(MovieVO vo);
	
	// ��ȭ ����
	public void updateMovie(MovieVO vo);
	
	
	// 07. �Խñ� ���ڵ� ���� �޼��� 
	public int countArticle(String searchOption, String keyword) throws Exception;
		
	

}

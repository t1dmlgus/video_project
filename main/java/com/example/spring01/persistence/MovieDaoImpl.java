package com.example.spring01.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;


import com.example.spring01.domain.MovieVO;



@Repository
public class MovieDaoImpl implements MovieDao{

	
	@Inject
	SqlSession sqlSession;


	//01. ��ȭ���(�˻�)
	@Override
	public List<MovieVO> movieList(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("searchOption", searchOption);
		 map.put("keyword", keyword);
		
		 
		return sqlSession.selectList("movie.movieList",map);
	}

	
	//01. ��ȭ ������(����Ʈ)
	@Override
	public List<MovieVO> view2Movie(String mno) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("movie.view2Movie", mno);
		
	}

	
	//01. ��ȭ ������(����)
	@Override
	public MovieVO select2Movie(String mno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("movie.select2Movie", mno);
	}


	
	
	
	
	
	
	//01. �������(�˻�)
	@Override
	public List<MovieVO> listAll(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("searchOption", searchOption);
		 map.put("keyword", keyword);
		
		 
		return sqlSession.selectList("movie.listAll",map);
	}
	
	// 03.��ȭ ���
	@Override
	public void insertMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("movie.insertMovie", vo);
	}
	
	
	// 03.���� ���	
	@Override
	public void insertVideo(MovieVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("movie.insertVideo", vo);
	}
	
	
	
	
	// 02_01. ��ȭ�˻�
	
	
	
	
	
	//02.  ��ȭ ����ȸ
	@Override
	public MovieVO viewMovie(String vno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("movie.viewMember",vno);
	}
	
	
	
	// ��ȭ ����
	@Override
	public void deleteMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		sqlSession.delete("movie.deleteMovie",vo);
	}

	
	// ��ȭ ����
	@Override
	public void updateMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update("movie.updateMovie",vo);
	}
	
	// 07. �Խñ� ���ڵ� ���� �޼��� 
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		
		//�˻� �ɼ�, Ű���� �ʿ� ����
		Map<String,String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		return sqlSession.selectOne("movie.countArticle", map);
	}





	




	
	
	
	

}

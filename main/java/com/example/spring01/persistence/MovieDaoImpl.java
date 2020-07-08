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


	//01. 영화목록(검색)
	@Override
	public List<MovieVO> movieList(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("searchOption", searchOption);
		 map.put("keyword", keyword);
		
		 
		return sqlSession.selectList("movie.movieList",map);
	}

	
	//01. 영화 상세정보(리스트)
	@Override
	public List<MovieVO> view2Movie(String mno) {
		// TODO Auto-generated method stub
		
		return sqlSession.selectList("movie.view2Movie", mno);
		
	}

	
	//01. 영화 상세정보(단일)
	@Override
	public MovieVO select2Movie(String mno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("movie.select2Movie", mno);
	}


	
	
	
	
	
	
	//01. 비디오목록(검색)
	@Override
	public List<MovieVO> listAll(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		
		 Map<String, String> map = new HashMap<String, String>();
		 map.put("searchOption", searchOption);
		 map.put("keyword", keyword);
		
		 
		return sqlSession.selectList("movie.listAll",map);
	}
	
	// 03.영화 등록
	@Override
	public void insertMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("movie.insertMovie", vo);
	}
	
	
	// 03.비디오 등록	
	@Override
	public void insertVideo(MovieVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("movie.insertVideo", vo);
	}
	
	
	
	
	// 02_01. 영화검색
	
	
	
	
	
	//02.  영화 상세조회
	@Override
	public MovieVO viewMovie(String vno) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("movie.viewMember",vno);
	}
	
	
	
	// 영화 삭제
	@Override
	public void deleteMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		sqlSession.delete("movie.deleteMovie",vo);
	}

	
	// 영화 수정
	@Override
	public void updateMovie(MovieVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update("movie.updateMovie",vo);
	}
	
	// 07. 게시글 레코드 개수 메서드 
	@Override
	public int countArticle(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		
		//검색 옵션, 키워드 맵에 저장
		Map<String,String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		return sqlSession.selectOne("movie.countArticle", map);
	}





	




	
	
	
	

}

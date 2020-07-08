package com.example.spring01.persistence;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.domain.MemberVO;



public interface MemberDao {
	// 회원목록
	public List<MemberVO> memberList();
	
	// 01_02. 검색 회원 목록 
	public List<MemberVO> listAll(String searchOption, String keyword) throws Exception;
	
	
	// 삽입
	public void insertMember(MemberVO vo);
	
	// 조회
	public MemberVO viewMember(String userId);
	
	// 삭제
	public void deleteMember(String userId);
	
	// 수정
	public void updateMember(MemberVO vo);
	
	// 비밀번호 확인
	public boolean checkPw(String userId, String userPass);

	
	
	boolean loginCheck(MemberVO vo);

	MemberVO viewMember(MemberVO vo);

	void logout(HttpSession session);
	
	

}

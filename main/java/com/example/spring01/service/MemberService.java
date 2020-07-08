package com.example.spring01.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.domain.MemberVO;



public interface MemberService {
	//  회원 목록 서비스
	public List<MemberVO> memberList();
	
	// 검색 목록 서비스
	public List<MemberVO> listAll(String searchOption, String keyword) throws Exception;
	
	
	// 회원 삽입 서비스
	public void insertMember(MemberVO vo);
	
	// 회원 상세조회 서비스
	public MemberVO viewMember(String userId);
	
	// 회원 삭제 서비스
	public void deleteMember(String userId);
	
	// 회원 수정 서비스 
	public void updateMember(MemberVO vo);

	// 회원 정보 수정 및 삭제를 위한 비밀번호 체크
	public boolean checkPw(String userId, String userPass);

	
	
	
	// 01_01. 회원 로그인 체크
	public boolean loginCheck(MemberVO vo, HttpSession session);
	
	// 01_02. 회원 로그인 정보
	public MemberVO viewMember(MemberVO vo);
	
	// 01_03. 회원 로그아웃
	public void logout(HttpSession session);
}

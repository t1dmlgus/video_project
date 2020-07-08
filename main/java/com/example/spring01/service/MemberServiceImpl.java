package com.example.spring01.service;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.example.spring01.domain.MemberVO;
import com.example.spring01.persistence.MemberDaoImpl;

@Repository
public class MemberServiceImpl implements MemberService{

	@Inject
	MemberDaoImpl memberDao;
	
	// 01. 회원 목록 서비스
	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return memberDao.memberList();
	}
	
	
	// 01_02. 검색 회원 목록 서비스
	@Override
	public List<MemberVO> listAll(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.listAll(searchOption, keyword);
	}
	
	
	// 02. 회원등록
	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDao.insertMember(vo);
		
	}

	
	// 03. 회원 정보 상세 조회
	@Override
	public MemberVO viewMember(String userId) {
		return memberDao.viewMember(userId);
	}

	
	// 05. 회원 정보 삭제
	@Override
	public void deleteMember(String userId) {
		// TODO Auto-generated method stub
		memberDao.deleteMember(userId);
	}
	
	// 04. 회원 정보 수정
	@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDao.updateMember(vo);
	}

	// 07. 수정 삭제 시 비밀번호 체크
	@Override
	public boolean checkPw(String userId, String userPass) {
		return memberDao.checkPw(userId, userPass);
	}

	
	
	
	//06_02. 로그인 처리
	@Override
	public boolean loginCheck(MemberVO vo, HttpSession session) {
		
		boolean result = memberDao.loginCheck(vo);
		if(result) {
						// result == true 일 경우 세션에 등록
			MemberVO vo2 = viewMember(vo);
			
			//session 변수 등록
			session.setAttribute("userId", vo2.getUserId());
			session.setAttribute("userName", vo2.getUserName());
			session.setAttribute("verify", vo2.getVerify());
			
		}
		
		return result;
	}
	
	//06_03. 로그인 회원 정보
	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDao.viewMember(vo);
	}

	
	//07. 로그아웃
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
		session.invalidate();
		
	}

	
}

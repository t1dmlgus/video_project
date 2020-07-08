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
	
	// 01. ȸ�� ��� ����
	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return memberDao.memberList();
	}
	
	
	// 01_02. �˻� ȸ�� ��� ����
	@Override
	public List<MemberVO> listAll(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		return memberDao.listAll(searchOption, keyword);
	}
	
	
	// 02. ȸ�����
	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDao.insertMember(vo);
		
	}

	
	// 03. ȸ�� ���� �� ��ȸ
	@Override
	public MemberVO viewMember(String userId) {
		return memberDao.viewMember(userId);
	}

	
	// 05. ȸ�� ���� ����
	@Override
	public void deleteMember(String userId) {
		// TODO Auto-generated method stub
		memberDao.deleteMember(userId);
	}
	
	// 04. ȸ�� ���� ����
	@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDao.updateMember(vo);
	}

	// 07. ���� ���� �� ��й�ȣ üũ
	@Override
	public boolean checkPw(String userId, String userPass) {
		return memberDao.checkPw(userId, userPass);
	}

	
	
	
	//06_02. �α��� ó��
	@Override
	public boolean loginCheck(MemberVO vo, HttpSession session) {
		
		boolean result = memberDao.loginCheck(vo);
		if(result) {
						// result == true �� ��� ���ǿ� ���
			MemberVO vo2 = viewMember(vo);
			
			//session ���� ���
			session.setAttribute("userId", vo2.getUserId());
			session.setAttribute("userName", vo2.getUserName());
			session.setAttribute("verify", vo2.getVerify());
			
		}
		
		return result;
	}
	
	//06_03. �α��� ȸ�� ����
	@Override
	public MemberVO viewMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return memberDao.viewMember(vo);
	}

	
	//07. �α׾ƿ�
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
		session.invalidate();
		
	}

	
}

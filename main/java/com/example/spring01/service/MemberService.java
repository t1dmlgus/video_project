package com.example.spring01.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.domain.MemberVO;



public interface MemberService {
	//  ȸ�� ��� ����
	public List<MemberVO> memberList();
	
	// �˻� ��� ����
	public List<MemberVO> listAll(String searchOption, String keyword) throws Exception;
	
	
	// ȸ�� ���� ����
	public void insertMember(MemberVO vo);
	
	// ȸ�� ����ȸ ����
	public MemberVO viewMember(String userId);
	
	// ȸ�� ���� ����
	public void deleteMember(String userId);
	
	// ȸ�� ���� ���� 
	public void updateMember(MemberVO vo);

	// ȸ�� ���� ���� �� ������ ���� ��й�ȣ üũ
	public boolean checkPw(String userId, String userPass);

	
	
	
	// 01_01. ȸ�� �α��� üũ
	public boolean loginCheck(MemberVO vo, HttpSession session);
	
	// 01_02. ȸ�� �α��� ����
	public MemberVO viewMember(MemberVO vo);
	
	// 01_03. ȸ�� �α׾ƿ�
	public void logout(HttpSession session);
}

package com.example.spring01.persistence;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.domain.MemberVO;



public interface MemberDao {
	// ȸ�����
	public List<MemberVO> memberList();
	
	// 01_02. �˻� ȸ�� ��� 
	public List<MemberVO> listAll(String searchOption, String keyword) throws Exception;
	
	
	// ����
	public void insertMember(MemberVO vo);
	
	// ��ȸ
	public MemberVO viewMember(String userId);
	
	// ����
	public void deleteMember(String userId);
	
	// ����
	public void updateMember(MemberVO vo);
	
	// ��й�ȣ Ȯ��
	public boolean checkPw(String userId, String userPass);

	
	
	boolean loginCheck(MemberVO vo);

	MemberVO viewMember(MemberVO vo);

	void logout(HttpSession session);
	
	

}

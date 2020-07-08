package com.example.spring01.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.domain.MemberVO;



@Repository
public class MemberDaoImpl implements MemberDao{

	
	@Inject
	SqlSession sqlSession;
	
	
	// 01. ��ü ȸ�� ��� ��ȸ
	@Override
	public List<MemberVO> memberList() {
		// TODO Auto-generated method stub
		return null;//sqlSession.selectList("member.memberList");		//memberMapper
	}

	// 01_02. �˻� ȸ�� ���
	@Override
	public List<MemberVO> listAll(String searchOption, String keyword) throws Exception {
		// TODO Auto-generated method stub
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		return sqlSession.selectList("member.listAll",map);
	}
	
	// 04. ȸ�� ���
	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("member.insertMember", vo);
	}
	
	// 02. ȸ�� ����ȸ
	@Override
	public MemberVO viewMember(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("member.viewMember", userId);
	}

	@Override
	public void deleteMember(String userId) {
		// TODO Auto-generated method stub
		sqlSession.delete("member.deleteMember",userId);
	}

	@Override
	public void updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		sqlSession.update("member.updateMember", vo);
	}

	
	@Override
	public boolean checkPw(String userId, String userPass) {
		boolean result = false;	//default
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPass", userPass);
		int count = sqlSession.selectOne("member.checkPw", map); 
		if(count == 1) result= true;
		return result;
	}
	


	// 01_01. ȸ�� �α��� üũ	
	@Override
	public boolean loginCheck(MemberVO vo) {
		
		String name = sqlSession.selectOne("member.loginCheck",vo);
		return (name == null)? false:true;
	}
	
	// 01_02. ȸ�� �α��� ����
	@Override
	public MemberVO viewMember(MemberVO vo) {

		return sqlSession.selectOne("member.viewMember", vo);
	}
	
	// 01_03. ȸ�� �α׾ƿ�
	@Override
	public void logout(HttpSession session) {
		// TODO Auto-generated method stub
		
	}

	

}

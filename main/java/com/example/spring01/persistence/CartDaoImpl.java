package com.example.spring01.persistence;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring01.domain.CartVO;
import com.example.spring01.domain.MemberVO;



@Repository
public class CartDaoImpl implements CartDao{

	
	@Inject
	SqlSession sqlSession;

	
	
	// 02_01. �뿩 ���(������)
	@Override
	public List<CartVO> listCart() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.listCart");
	}
	
	
	// 02_01. �뿩 ���(����¡)
	@Override
	public List<CartVO> listCartPage(int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		 HashMap data = new HashMap();
		  
		 data.put("displayPost", displayPost);
		 data.put("postNum", postNum);
		
		
		
		return sqlSession.selectList("cart.listCartPage",data);
	}
	
	
	
	
	
	// 02_02. �뿩 ���(����)
	@Override
	public List<CartVO> listCart(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.listCart2",userId);
	}
	
	
	
	
	
	// 01. �뿩 �߰�
	@Override
	public void insert(CartVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("cart.insertCart",vo);
	}

	
	
	
	
	
	// 03. �뿩 �ݳ�
	@Override
	public void returnVideo(CartVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("cart.ReturnCart",vo);
	}
	
	
	
	
	// 03. ��ٱ��� ����
	@Override
	public void delete(int cartId) {
		// TODO Auto-generated method stub
		
	}

	// 04. ��ٱ��� ����
	@Override
	public void update(CartVO vo) {
		// TODO Auto-generated method stub
		
	}

	// 05. ��ٱ��� �ݾ� �հ�
	@Override
	public int sumMoney(String userId) {

		return 0;//sqlSession.selectOne("cart.sumMoney", userId);
	}

	// 06. ��ٱ��� ������ ��ǰ ���ڵ�Ȯ��
	@Override
	public int countCart(String vno, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vno", vno);
		map.put("userId", userId);
		return sqlSession.selectOne("cart.countCart", map);
	}
	// 07. ��ٱ��� ��ǰ ���� ����
	@Override
	public void updateCart(CartVO vo) {
		sqlSession.update("cart.sumCart", vo);
	}


	
	
	
	//09. ������ (��)
	@Override
	public List<CartVO> priceList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.priceList");
	}


	//10. ������� (��)
	@Override
	public List<CartVO> priceMonth(CartVO vo) {
		// TODO Auto-generated method stub
		
		/*
		HashMap data = new HashMap();
		data.put("displayPost", displayPost);
		data.put("postNum", postNum);
		*/
		
		
		return sqlSession.selectList("cart.priceMonth", vo);
	}

	
	//11. ������� (��)
	@Override
	public List<CartVO> priceYear(CartVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.priceYear", vo);
	}

	//12. �� ����
	public int count() {
		
		
		return sqlSession.selectOne("cart.count");
	};





	
}

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

	
	
	// 02_01. 대여 목록(관리자)
	@Override
	public List<CartVO> listCart() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.listCart");
	}
	
	
	// 02_01. 대여 목록(페이징)
	@Override
	public List<CartVO> listCartPage(int displayPost, int postNum) {
		// TODO Auto-generated method stub
		
		 HashMap data = new HashMap();
		  
		 data.put("displayPost", displayPost);
		 data.put("postNum", postNum);
		
		
		
		return sqlSession.selectList("cart.listCartPage",data);
	}
	
	
	
	
	
	// 02_02. 대여 목록(개인)
	@Override
	public List<CartVO> listCart(String userId) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.listCart2",userId);
	}
	
	
	
	
	
	// 01. 대여 추가
	@Override
	public void insert(CartVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("cart.insertCart",vo);
	}

	
	
	
	
	
	// 03. 대여 반납
	@Override
	public void returnVideo(CartVO vo) {
		// TODO Auto-generated method stub
		sqlSession.insert("cart.ReturnCart",vo);
	}
	
	
	
	
	// 03. 장바구니 삭제
	@Override
	public void delete(int cartId) {
		// TODO Auto-generated method stub
		
	}

	// 04. 장바구니 수정
	@Override
	public void update(CartVO vo) {
		// TODO Auto-generated method stub
		
	}

	// 05. 장바구니 금액 합계
	@Override
	public int sumMoney(String userId) {

		return 0;//sqlSession.selectOne("cart.sumMoney", userId);
	}

	// 06. 장바구니 동일한 상품 레코드확인
	@Override
	public int countCart(String vno, String userId) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vno", vno);
		map.put("userId", userId);
		return sqlSession.selectOne("cart.countCart", map);
	}
	// 07. 장바구니 상품 수량 변경
	@Override
	public void updateCart(CartVO vo) {
		sqlSession.update("cart.sumCart", vo);
	}


	
	
	
	//09. 정산목록 (일)
	@Override
	public List<CartVO> priceList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.priceList");
	}


	//10. 정산관리 (월)
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

	
	//11. 정산관리 (년)
	@Override
	public List<CartVO> priceYear(CartVO vo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("cart.priceYear", vo);
	}

	//12. 총 개수
	public int count() {
		
		
		return sqlSession.selectOne("cart.count");
	};





	
}

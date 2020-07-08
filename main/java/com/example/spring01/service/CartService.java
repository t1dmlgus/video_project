package com.example.spring01.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.domain.CartVO;



	

public interface CartService {

	//01. 대여 추가
	public void insert(CartVO vo);
	
	
	
	//02. 대여 목록 (관리자)
	public List<CartVO> listCart();
	
	
	//02. 대여 목록 (페이지)
	public List<CartVO> listCartPage(int displayPost, int postNum);
		
	
	
	//02_02. 대여 목록 (개인)
	public List<CartVO> listCart(String userId);
	
	
	//03. 대여 반납
	public void returnVideo(CartVO vo);
	
	
	//03. 대여 삭제
	public void delete(int cartId);
	
	//04. 장바구니 수정
	public void update(CartVO vo);

	
	
	//05. 장바구니 금액 합계
	public int sumMoney(String userId);

	
	
	
	//06. 장바구니 상품 확인
	public int countCart(String vno, String userId);
	
	
	

	//07. 장바구니 상품 수량 변경
	public void updateCart(CartVO vo);
	
	
	//08. 대여일 - 반납일 계산 
	public void calDateBetweenAandB(List<CartVO> list);
	
	//09. 정산목록 (일)
	public List<CartVO> priceList();


	// 10. 정산 관리 (월)
	//public List<CartVO> priceMonth(int displayPost, int postNum);
	public List<CartVO> priceMonth(CartVO vo);
	
	// 11. 정산 관리 (년)
	public List<CartVO> priceYear(CartVO vo);
	
	// 12. 정산 관리 총개수
	public int count();
}

package com.example.spring01.persistence;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.domain.CartVO;




public interface CartDao {

	//01. 대여목록 추가
	public void insert(CartVO vo);
		
	
	
	
	
	// 02_01. 대여 목록(관리자)
	public List<CartVO> listCart();
	
	
	public List<CartVO> listCartPage(int displayPost, int postNum);

	
	// 02_02. 대여 목록(개인)
	public List<CartVO> listCart(String userId);
	
	
	// 03 대여 반납
	public void returnVideo(CartVO vo);
	
	
	
	// 삭제
	public void delete(int cartId);
	
	// 수정
	public void update(CartVO vo);

	int sumMoney(String userId);

	int countCart(String vno, String userId);

	void updateCart(CartVO vo);
	

	//09. 정산 목록(일)
	public List<CartVO> priceList();




	//10. 정산관리 (월)
	//public List<CartVO> priceMonth(int displayPost, int postNum);
	public List<CartVO> priceMonth(CartVO vo);



	//11. 정산관리 (년)
	public List<CartVO> priceYear(CartVO vo);

	
	//12. 총 개수
		public int count();
}

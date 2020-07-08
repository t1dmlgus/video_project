package com.example.spring01.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.example.spring01.domain.CartVO;

import com.example.spring01.persistence.CartDao;


@Repository
public class CartServiceImpl implements CartService{

	@Inject
	CartDao cartDao;

	
	// 01. 대여 추가
	@Override
	public void insert(CartVO vo) {
		// TODO Auto-generated method stub
		cartDao.insert(vo);
		
	}

	// 02. 대여 목록(관리인)
	@Override
	public List<CartVO> listCart() {
		// TODO Auto-generated method stub
		return cartDao.listCart();
	}

	// 02. 대여 목록(관리인)
		@Override
		public List<CartVO> listCartPage(int displayPost, int postNum) {
			// TODO Auto-generated method stub
			return cartDao.listCartPage(displayPost,postNum);
		}
	
	
	
	
	
	
	// 02_02. 대여 목록(개인)
	@Override
	public List<CartVO> listCart(String userId) {
		// TODO Auto-generated method stub
		return cartDao.listCart(userId);
	}

	
	// 03. 대여 반납
		@Override
		public void returnVideo(CartVO vo) {
			// TODO Auto-generated method stub
			cartDao.returnVideo(vo);
		}
	

	// 03. 대여 삭제
	@Override
	public void delete(int cartId) {
		// TODO Auto-generated method stub
		
	}

	// 04. 장바구니 수정
	@Override
	public void update(CartVO vo) {
		// TODO Auto-generated method stub
		
	}
	
	//05. 장바구니 금액 합계
	@Override
	public int sumMoney(String userId) {
		return cartDao.sumMoney(userId);
	}
	
	//06. 장바구니 상품 확인
	@Override
	public int countCart(String vno, String userId) {
		return cartDao.countCart(vno, userId);
	}
	
	//07. 장바구니 상품 수량 변경
	@Override
	public void  updateCart(CartVO vo) {
		cartDao.update(vo);
	}

	
	
	//08. 대여일 - 반납일 날짜계산
	@Override
	public void calDateBetweenAandB(List<CartVO> list) {
		// TODO Auto-generated method stub
		
		
	}

	//09. 정산 목록 (일)
	@Override
	public List<CartVO> priceList() {
		// TODO Auto-generated method stub
		return cartDao.priceList();
	}

	
	//10. 정산관리 (월)
	@Override
	public List<CartVO> priceMonth(CartVO vo) {
		// TODO Auto-generated method stub
		return cartDao.priceMonth(vo);
	}

	
	//11. 정산관리 (년)
	@Override
	public List<CartVO> priceYear(CartVO vo) {
		// TODO Auto-generated method stub
		return cartDao.priceYear(vo);
	}
	

	//12. 정산관리 총 개수
	public int count() {
		
		return cartDao.count();
	}

	
	


		
	
	
	
	
	
	
	
}

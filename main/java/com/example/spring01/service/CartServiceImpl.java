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

	
	// 01. �뿩 �߰�
	@Override
	public void insert(CartVO vo) {
		// TODO Auto-generated method stub
		cartDao.insert(vo);
		
	}

	// 02. �뿩 ���(������)
	@Override
	public List<CartVO> listCart() {
		// TODO Auto-generated method stub
		return cartDao.listCart();
	}

	// 02. �뿩 ���(������)
		@Override
		public List<CartVO> listCartPage(int displayPost, int postNum) {
			// TODO Auto-generated method stub
			return cartDao.listCartPage(displayPost,postNum);
		}
	
	
	
	
	
	
	// 02_02. �뿩 ���(����)
	@Override
	public List<CartVO> listCart(String userId) {
		// TODO Auto-generated method stub
		return cartDao.listCart(userId);
	}

	
	// 03. �뿩 �ݳ�
		@Override
		public void returnVideo(CartVO vo) {
			// TODO Auto-generated method stub
			cartDao.returnVideo(vo);
		}
	

	// 03. �뿩 ����
	@Override
	public void delete(int cartId) {
		// TODO Auto-generated method stub
		
	}

	// 04. ��ٱ��� ����
	@Override
	public void update(CartVO vo) {
		// TODO Auto-generated method stub
		
	}
	
	//05. ��ٱ��� �ݾ� �հ�
	@Override
	public int sumMoney(String userId) {
		return cartDao.sumMoney(userId);
	}
	
	//06. ��ٱ��� ��ǰ Ȯ��
	@Override
	public int countCart(String vno, String userId) {
		return cartDao.countCart(vno, userId);
	}
	
	//07. ��ٱ��� ��ǰ ���� ����
	@Override
	public void  updateCart(CartVO vo) {
		cartDao.update(vo);
	}

	
	
	//08. �뿩�� - �ݳ��� ��¥���
	@Override
	public void calDateBetweenAandB(List<CartVO> list) {
		// TODO Auto-generated method stub
		
		
	}

	//09. ���� ��� (��)
	@Override
	public List<CartVO> priceList() {
		// TODO Auto-generated method stub
		return cartDao.priceList();
	}

	
	//10. ������� (��)
	@Override
	public List<CartVO> priceMonth(CartVO vo) {
		// TODO Auto-generated method stub
		return cartDao.priceMonth(vo);
	}

	
	//11. ������� (��)
	@Override
	public List<CartVO> priceYear(CartVO vo) {
		// TODO Auto-generated method stub
		return cartDao.priceYear(vo);
	}
	

	//12. ������� �� ����
	public int count() {
		
		return cartDao.count();
	}

	
	


		
	
	
	
	
	
	
	
}

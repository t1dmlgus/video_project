package com.example.spring01.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.domain.CartVO;



	

public interface CartService {

	//01. �뿩 �߰�
	public void insert(CartVO vo);
	
	
	
	//02. �뿩 ��� (������)
	public List<CartVO> listCart();
	
	
	//02. �뿩 ��� (������)
	public List<CartVO> listCartPage(int displayPost, int postNum);
		
	
	
	//02_02. �뿩 ��� (����)
	public List<CartVO> listCart(String userId);
	
	
	//03. �뿩 �ݳ�
	public void returnVideo(CartVO vo);
	
	
	//03. �뿩 ����
	public void delete(int cartId);
	
	//04. ��ٱ��� ����
	public void update(CartVO vo);

	
	
	//05. ��ٱ��� �ݾ� �հ�
	public int sumMoney(String userId);

	
	
	
	//06. ��ٱ��� ��ǰ Ȯ��
	public int countCart(String vno, String userId);
	
	
	

	//07. ��ٱ��� ��ǰ ���� ����
	public void updateCart(CartVO vo);
	
	
	//08. �뿩�� - �ݳ��� ��� 
	public void calDateBetweenAandB(List<CartVO> list);
	
	//09. ������ (��)
	public List<CartVO> priceList();


	// 10. ���� ���� (��)
	//public List<CartVO> priceMonth(int displayPost, int postNum);
	public List<CartVO> priceMonth(CartVO vo);
	
	// 11. ���� ���� (��)
	public List<CartVO> priceYear(CartVO vo);
	
	// 12. ���� ���� �Ѱ���
	public int count();
}

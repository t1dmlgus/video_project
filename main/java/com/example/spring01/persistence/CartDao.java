package com.example.spring01.persistence;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring01.domain.CartVO;




public interface CartDao {

	//01. �뿩��� �߰�
	public void insert(CartVO vo);
		
	
	
	
	
	// 02_01. �뿩 ���(������)
	public List<CartVO> listCart();
	
	
	public List<CartVO> listCartPage(int displayPost, int postNum);

	
	// 02_02. �뿩 ���(����)
	public List<CartVO> listCart(String userId);
	
	
	// 03 �뿩 �ݳ�
	public void returnVideo(CartVO vo);
	
	
	
	// ����
	public void delete(int cartId);
	
	// ����
	public void update(CartVO vo);

	int sumMoney(String userId);

	int countCart(String vno, String userId);

	void updateCart(CartVO vo);
	

	//09. ���� ���(��)
	public List<CartVO> priceList();




	//10. ������� (��)
	//public List<CartVO> priceMonth(int displayPost, int postNum);
	public List<CartVO> priceMonth(CartVO vo);



	//11. ������� (��)
	public List<CartVO> priceYear(CartVO vo);

	
	//12. �� ����
		public int count();
}

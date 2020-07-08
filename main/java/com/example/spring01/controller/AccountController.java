package com.example.spring01.controller;

import java.io.PrintWriter;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.domain.CartVO;
import com.example.spring01.domain.MemberVO;
import com.example.spring01.domain.MovieVO;
import com.example.spring01.service.CartService;
import com.example.spring01.service.MemberService;
import com.example.spring01.service.MovieServiceImpl;

@Controller
@RequestMapping("/account/*")
public class AccountController {
	
	
	
	@Inject
	CartService cartService;
	
	
	
	
	//public String memberManage() {
	// 01. ���� ���� ������ �̵�
	@RequestMapping("account_manage.do")
	public String rentManage(CartVO vo) {
	
		
		cartService.listCart();
		
		return "account/account_manage";
	}
	
	// 02. �� ���� �������� �̵�
	@GetMapping("account_day.do")
	public ModelAndView rent_day(CartVO vo, ModelAndView mav) {
	
		
		
		
		
		List<CartVO> list=  cartService.priceList();
		System.out.println("day------------");
	
		if(list.size() == 0) {
		
			mav.setViewName("/account/account_list");
			return mav;	
		}else {
			
			int t2 =0;//����
			int t3 = 0; //����
			for(int i=0;i<list.size();i++) {
				
				System.out.println(list.get(i).getVno());
				System.out.println(list.get(i).getRentdate());
				System.out.println(list.get(i).getMovie());
				
				
				
				t2 += list.get(i).getPrice();
			
			}
				t3 = list.size();
			
			
			System.out.println("����");	
			System.out.println(t2);
			System.out.println("����");
			System.out.println(t3);
			
			vo.setSumprice(t2);
			System.out.println("vo�� setSumprice");
			System.out.println("sumprice:"+vo.getSumprice());
			
			vo.setSumstate(t3);
			System.out.println("vo�� setSumstate");
			System.out.println("sumstate:"+vo.getSumstate());
			
			
			vo.setRentdate(list.get(0).getRentdate());
			
			System.out.println("get"+vo.getRentdate());
			
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("list", list);		
			mav.setViewName("/account/account_list");	
			mav.addObject("map",map);	
			
			return mav;
			
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	// 03. �� ���� �������� �̵�	
	@RequestMapping("account_month.do")

	public String rent_month(CartVO vo, ModelAndView mav) {
		
		System.out.println("�Ѿ��1");
		
		System.out.println("������1");
		
	
		return "account/account_month";
	}
	
	
	
	
	// 03. �� ���� �������� �̵�	+ ����¡
	@RequestMapping("account_month2.do")
	public ModelAndView rent_month2(CartVO vo, ModelAndView mav) {
		System.out.println("monthpost---------");
		System.out.println("month �Ѿ����");
		System.out.println(vo.getMonth());
		
		/*
		// �Խù� �Ѱ���
		int count = cartService.count();
		System.out.println(count);
		System.out.println("count�ϰ�");
		// �� �������� ����� �Խù� ����
		int postNum = 10;
		
		// �ϴ� ����¡ ��ȣ([ �Խù� �� ���� % �� �������� ��� �� ����] �� �ø�)
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		System.out.println("pageNu1m:"+pageNum);
		
		// ����� �Խù�
		int displayPost = (num -1) * postNum;
		
		System.out.println("displayPos1t: "+displayPost);
		System.out.println("nu1m: "+num);
		
		System.out.println("pageNu2m:"+pageNum);
		System.out.println("displayPos2t: "+displayPost);
		System.out.println("nu2m: "+num);
		
		*/
		System.out.println("list ������");
		List<CartVO> list=  cartService.priceMonth(vo);
		System.out.println("��������");
	

		
		
		int t2 =0;
		int t3 =0;
		for(int i=0;i<list.size();i++) {
			

				
			System.out.println("list[i]");
			System.out.println(list.get(i).getRentdate());
			System.out.println(list.get(i).getState());
			
			list.get(i).setSumprice(list.get(i).getState() * 2000);
			
		
			System.out.println(list.get(i).getSumprice());
			
			t2 += list.get(i).getSumprice(); // �� �ݾ�
			t3 += list.get(i).getState();	// �� ����
		}

		
		
		System.out.println(t2);
		vo.setTotalprice(t2);
		
		System.out.println(t3);
		vo.setSumstate(t3);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		
		/*
		

		System.out.println("set���ϰ�");
		System.out.println("sumprice:"+vo.getSumprice());
		
		*/
		//map.put("pageNum", pageNum);
		//map.put("num", num);
		
		mav.setViewName("/account/account_month");	
		mav.addObject("map",map);	
		
		return mav;
		/*
		model.addAttribute("list",list);
		model.addAttribute("postNum",postNum);
		model.addAttribute("num",num);
		
		return "/account/account_month";
		*/
	}
	
	
	
	
	
	
	// 04. �� ���� �������� �̵�	
	@RequestMapping("account_year.do")
	public ModelAndView rent_year(CartVO vo, ModelAndView mav) {
		
		System.out.println("�Ѿ��2");
		System.out.println(vo.getYear());
		List<CartVO> list=  cartService.priceYear(vo);
		System.out.println("������2");
	
		
		int t2 =0;
		int t3 =0;
		Date t4 = null ;
		for(int i=0;i<list.size();i++) {
			
			
			System.out.println("list[i]");
			System.out.println(list.get(i).getRentdate());
			System.out.println(list.get(i).getState());
			
			list.get(i).setSumprice(list.get(i).getState() * 2000);
			
			
			System.out.println(list.get(i).getSumprice());
			
			t2 += list.get(i).getSumprice(); // �� �ݾ�
			t3 += list.get(i).getState();	// �� ����
			
			t4 = list.get(i).getRentdate();
				
		}
		
		System.out.println(t2);
		vo.setTotalprice(t2);
		
		vo.setRentdate(t4);
		System.out.println(t3);
		vo.setSumstate(t3);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);		
		mav.setViewName("/account/account_year");	
		mav.addObject("map",map);	
		
		return mav;
	}
	
		
}
	
	
	
	

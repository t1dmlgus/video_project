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
	// 01. 정산 관리 페이지 이동
	@RequestMapping("account_manage.do")
	public String rentManage(CartVO vo) {
	
		
		cartService.listCart();
		
		return "account/account_manage";
	}
	
	// 02. 일 정산 페이지로 이동
	@GetMapping("account_day.do")
	public ModelAndView rent_day(CartVO vo, ModelAndView mav) {
	
		
		
		
		
		List<CartVO> list=  cartService.priceList();
		System.out.println("day------------");
	
		if(list.size() == 0) {
		
			mav.setViewName("/account/account_list");
			return mav;	
		}else {
			
			int t2 =0;//가격
			int t3 = 0; //개수
			for(int i=0;i<list.size();i++) {
				
				System.out.println(list.get(i).getVno());
				System.out.println(list.get(i).getRentdate());
				System.out.println(list.get(i).getMovie());
				
				
				
				t2 += list.get(i).getPrice();
			
			}
				t3 = list.size();
			
			
			System.out.println("정산");	
			System.out.println(t2);
			System.out.println("개수");
			System.out.println(t3);
			
			vo.setSumprice(t2);
			System.out.println("vo에 setSumprice");
			System.out.println("sumprice:"+vo.getSumprice());
			
			vo.setSumstate(t3);
			System.out.println("vo에 setSumstate");
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
	
	
	
	
	
	
	
	
	
	// 03. 월 정산 페이지로 이동	
	@RequestMapping("account_month.do")

	public String rent_month(CartVO vo, ModelAndView mav) {
		
		System.out.println("넘어오1");
		
		System.out.println("가져오1");
		
	
		return "account/account_month";
	}
	
	
	
	
	// 03. 월 정산 페이지로 이동	+ 페이징
	@RequestMapping("account_month2.do")
	public ModelAndView rent_month2(CartVO vo, ModelAndView mav) {
		System.out.println("monthpost---------");
		System.out.println("month 넘어오고");
		System.out.println(vo.getMonth());
		
		/*
		// 게시물 총개수
		int count = cartService.count();
		System.out.println(count);
		System.out.println("count하고");
		// 한 페이지에 출력할 게시물 개수
		int postNum = 10;
		
		// 하단 페이징 번호([ 게시물 총 개수 % 한 페이지에 출력 할 개수] 의 올림)
		int pageNum = (int)Math.ceil((double)count/postNum);
		
		System.out.println("pageNu1m:"+pageNum);
		
		// 출력할 게시물
		int displayPost = (num -1) * postNum;
		
		System.out.println("displayPos1t: "+displayPost);
		System.out.println("nu1m: "+num);
		
		System.out.println("pageNu2m:"+pageNum);
		System.out.println("displayPos2t: "+displayPost);
		System.out.println("nu2m: "+num);
		
		*/
		System.out.println("list 들어가기전");
		List<CartVO> list=  cartService.priceMonth(vo);
		System.out.println("가져오고");
	

		
		
		int t2 =0;
		int t3 =0;
		for(int i=0;i<list.size();i++) {
			

				
			System.out.println("list[i]");
			System.out.println(list.get(i).getRentdate());
			System.out.println(list.get(i).getState());
			
			list.get(i).setSumprice(list.get(i).getState() * 2000);
			
		
			System.out.println(list.get(i).getSumprice());
			
			t2 += list.get(i).getSumprice(); // 총 금액
			t3 += list.get(i).getState();	// 총 개수
		}

		
		
		System.out.println(t2);
		vo.setTotalprice(t2);
		
		System.out.println(t3);
		vo.setSumstate(t3);
		
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		
		
		/*
		

		System.out.println("set썸하고");
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
	
	
	
	
	
	
	// 04. 년 정산 페이지로 이동	
	@RequestMapping("account_year.do")
	public ModelAndView rent_year(CartVO vo, ModelAndView mav) {
		
		System.out.println("넘어오2");
		System.out.println(vo.getYear());
		List<CartVO> list=  cartService.priceYear(vo);
		System.out.println("가져오2");
	
		
		int t2 =0;
		int t3 =0;
		Date t4 = null ;
		for(int i=0;i<list.size();i++) {
			
			
			System.out.println("list[i]");
			System.out.println(list.get(i).getRentdate());
			System.out.println(list.get(i).getState());
			
			list.get(i).setSumprice(list.get(i).getState() * 2000);
			
			
			System.out.println(list.get(i).getSumprice());
			
			t2 += list.get(i).getSumprice(); // 총 금액
			t3 += list.get(i).getState();	// 총 개수
			
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
	
	
	
	

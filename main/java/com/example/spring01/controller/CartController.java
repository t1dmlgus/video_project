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
@RequestMapping("/cart/*")
public class CartController {
	
	
	
	@Inject
	CartService cartService;
	
	
	// 01. 대여 추가
	@RequestMapping("insert.do")
	public ModelAndView insert(CartVO vo, HttpSession session,ModelAndView mav, Locale local) {
		
		
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);

		System.out.println("dto:"+vo.getVno());
		
		System.out.println("이름:"+userId);
		
	
		//장바구니에 기존 상품이 있는지 검사
		//int count = cartService.countCart(vo.getVno(), userId);
		
		//count == 0 ? cartService.update(vo) : cartService.insert(vo);
		
		//if(count == 0) {
			cartService.insert(vo);
		//}else {
		//	cartService.update(vo);
		//}
		
		System.out.println("insert됫고");
		List<CartVO> list = cartService.listCart(userId);			
			
		
		System.out.println("list 됫고");
	
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("map 만들고");
	
		
		
		
		SimpleDateFormat sdf =new SimpleDateFormat("YYYY-MM-DD");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,local);
		// 대여일 localdate formattedDate
		for(int i = list.size()-1; i<list.size(); i++) {
			
		
			date = list.get(i).getRentdate();
			
			String formattedDate = dateFormat.format(date);
			
			
			
			
			System.out.println("FOR");
			System.out.println(list.get(i).getMovie());
			System.out.println(list.get(i).getRentdate());
			System.out.println("date tostring 1");
			
			System.out.println(sdf.format(list.get(i).getRentdate()));
			System.out.println("date sdf 2");
			
			
			
			System.out.println(list.get(i).getRentdate());
			System.out.println("date 그냥 3");
			System.out.println(date);
			System.out.println("date 그냥 4");
			
			System.out.println("대여일 get하고");
			
		/*	list.get(i).setRentdate(date);
			
			System.out.println("대여일 set하고");
			
			System.out.println(list.get(i).getRentdate());
			System.out.println("대여일 get하고");
		 */
		}
		
		
		map.put("list", list);
		System.out.println("map put하고");
		
		mav.setViewName("/cart/cartList");				// 뷰(jsp)에 이름 저장
		mav.addObject("map",map);					// map 에 변수 저장
		
		return mav;
		
	}
	
	

	// 02_02. 대여 목록 (개인)
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		
		String userId =(String) session.getAttribute("userId");			//session에 저장된 userId
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVO> list = cartService.listCart(userId);				// 장바구니 정보
		int sumMoney = cartService.sumMoney(userId);					// 장바구니 전체 금액 호출 
		
		// 장바구니 전체 금액에 따라 배송비 구분
		// 배송료(10만원 이상 -> 무료, 미만 -> 2500원)
		
		int fee =  sumMoney >= 10000 ? 0: 2500;
		
		map.put("list", list);						// 장바구니 정보를 map에 저장
		map.put("count", list.size());				// 장바구니 상품의 유무
		map.put("sumMoney", sumMoney);				// 장바구니 전체 금액
		map.put("fee", fee);						// 배송금액
		map.put("allSum", sumMoney+fee);			// 주문 상품 전체 금액
		
		mav.setViewName("/cart/cartList");				// 뷰(jsp)에 이름 저장
		mav.addObject("map",map);					// map 에 변수 저장
		
		return mav;
		
	
	}

	// 03. 대여 반납 
	@RequestMapping("return.do")
	public String returnVideo(@ModelAttribute CartVO vo, HttpSession session , Locale local) {

		
		System.out.println(vo.getVno());
		
		cartService.returnVideo(vo);
		
		/*
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, local);
		
		String formattedDate = dateFormat.format(date);
		*/
		
		
		
		
		System.out.println(vo.getMovie());
		System.out.println(vo.getRentdate());
		System.out.println(vo.getReturndate());
		System.out.println("date 적용 전 __");
		
		System.out.println(vo.getMovie());
		System.out.println(vo.getRentdate());
		
		//vo.setReturndate(date);
		
		System.out.println(vo.getReturndate());
		System.out.println("date 적용 후 __");
		
		return "cart/cartList";
	}
	
	
	
	
	
	
	
	
	
	/*
	
	//02. 대여 목록 페이지
	@RequestMapping("rent_list.do")
	public String memberManage() {
		
		return "rent/rent_list";
	}
	*/
	
	
	
	@RequestMapping("list21.do")
	public String  getListPage(Model model, @RequestParam("num") int num) {
		
		 // 게시물 총 갯수
		 int count = cartService.count();
		  
		 System.out.println("num값1"+num);
		 
		 // 한 페이지에 출력할 게시물 갯수
		 int postNum = 10;
		  
		 // 하단 페이징 번호 ([ 게시물 총 갯수 ÷ 한 페이지에 출력할 갯수 ]의 올림)
		 int pageNum = (int)Math.ceil((double)count/postNum);
		  
		 // 출력할 게시물
		 int displayPost = (num - 1) * postNum;
		    
		 
		 
		 
		// 한번에 표시할 페이징 번호의 갯수
		 int pageNum_cnt = 10;

		 // 표시되는 페이지 번호 중 마지막 번호
		 int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);

		 // 표시되는 페이지 번호 중 첫번째 번호
		 int startPageNum = endPageNum - (pageNum_cnt - 1);
		 
		 
		 
		 
		 // 마지막 번호 재계산
		 int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		 
		 if(endPageNum > endPageNum_tmp) {
		  endPageNum = endPageNum_tmp;
		 }
		 
		 
		 boolean prev = startPageNum == 1 ? false : true;
		 boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		 
		 
		 
		 
		// 시작 및 끝 번호
		 model.addAttribute("startPageNum", startPageNum);
		 model.addAttribute("endPageNum", endPageNum);

		 
		 // 이전 및 다음 
		 model.addAttribute("prev", prev);
		 model.addAttribute("next", next);
		 
		 
		 
		 
		 List list = null; 
		 list = cartService.listCartPage(displayPost, postNum);
		 model.addAttribute("list", list);   
		 model.addAttribute("pageNum", pageNum);
		 
		 return "cart/rent_list";
	}
	
	
	
	
	
	
	
	


	//02. 대여목록
	@RequestMapping("list2.do")
	public String memberList(Model model){
	// controller => service => dao 
		List<CartVO> list = cartService.listCart();
		model.addAttribute("list", list);
		
		
		
		
		
		
		
		
		
		
		
		/*
		//cartService.calDateBetweenAandB(list);
		
		Calendar cal = Calendar.getInstance();
		//Calendar cal = list.get(0).getRentdate();
		Calendar cal2 = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:dd");
		
				
		//list.get(2).getRentdate();					//calendar
		

		//cal.setTime(list.get(0).getRentdate());
		cal.set(Calendar.MILLISECOND,0);
		cal.add(Calendar.DATE, 2);
		
		cal2.set(Calendar.MILLISECOND,0);
		
		
		
		//Date returnDate = (Date) cal.getTime();
		
		Date returnDate = cal.getTime();
		Date nowDate = cal2.getTime();
		
		
		long calDate = (returnDate.getTime() - nowDate.getTime());
		long calDates = calDate / (24*60*60*1000);
		calDates = Math.abs(calDates);
		
		
		model.addAttribute("cal",cal);

		System.out.println(calDates);						// 시간 차이
		System.out.println(sdf.format(cal.getTime()));		// 대여일 +2 = 반납일
		
		System.out.println(sdf.format(cal2.getTime()));		// 현재시간
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return "cart/rent_list";
	}

	
}
	
	
	
	

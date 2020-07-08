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
	
	
	// 01. �뿩 �߰�
	@RequestMapping("insert.do")
	public ModelAndView insert(CartVO vo, HttpSession session,ModelAndView mav, Locale local) {
		
		
		String userId = (String) session.getAttribute("userId");
		vo.setUserId(userId);

		System.out.println("dto:"+vo.getVno());
		
		System.out.println("�̸�:"+userId);
		
	
		//��ٱ��Ͽ� ���� ��ǰ�� �ִ��� �˻�
		//int count = cartService.countCart(vo.getVno(), userId);
		
		//count == 0 ? cartService.update(vo) : cartService.insert(vo);
		
		//if(count == 0) {
			cartService.insert(vo);
		//}else {
		//	cartService.update(vo);
		//}
		
		System.out.println("insert�̰�");
		List<CartVO> list = cartService.listCart(userId);			
			
		
		System.out.println("list �̰�");
	
		Map<String, Object> map = new HashMap<String, Object>();
		System.out.println("map �����");
	
		
		
		
		SimpleDateFormat sdf =new SimpleDateFormat("YYYY-MM-DD");
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG,local);
		// �뿩�� localdate formattedDate
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
			System.out.println("date �׳� 3");
			System.out.println(date);
			System.out.println("date �׳� 4");
			
			System.out.println("�뿩�� get�ϰ�");
			
		/*	list.get(i).setRentdate(date);
			
			System.out.println("�뿩�� set�ϰ�");
			
			System.out.println(list.get(i).getRentdate());
			System.out.println("�뿩�� get�ϰ�");
		 */
		}
		
		
		map.put("list", list);
		System.out.println("map put�ϰ�");
		
		mav.setViewName("/cart/cartList");				// ��(jsp)�� �̸� ����
		mav.addObject("map",map);					// map �� ���� ����
		
		return mav;
		
	}
	
	

	// 02_02. �뿩 ��� (����)
	@RequestMapping("list.do")
	public ModelAndView list(HttpSession session, ModelAndView mav) {
		
		String userId =(String) session.getAttribute("userId");			//session�� ����� userId
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<CartVO> list = cartService.listCart(userId);				// ��ٱ��� ����
		int sumMoney = cartService.sumMoney(userId);					// ��ٱ��� ��ü �ݾ� ȣ�� 
		
		// ��ٱ��� ��ü �ݾ׿� ���� ��ۺ� ����
		// ��۷�(10���� �̻� -> ����, �̸� -> 2500��)
		
		int fee =  sumMoney >= 10000 ? 0: 2500;
		
		map.put("list", list);						// ��ٱ��� ������ map�� ����
		map.put("count", list.size());				// ��ٱ��� ��ǰ�� ����
		map.put("sumMoney", sumMoney);				// ��ٱ��� ��ü �ݾ�
		map.put("fee", fee);						// ��۱ݾ�
		map.put("allSum", sumMoney+fee);			// �ֹ� ��ǰ ��ü �ݾ�
		
		mav.setViewName("/cart/cartList");				// ��(jsp)�� �̸� ����
		mav.addObject("map",map);					// map �� ���� ����
		
		return mav;
		
	
	}

	// 03. �뿩 �ݳ� 
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
		System.out.println("date ���� �� __");
		
		System.out.println(vo.getMovie());
		System.out.println(vo.getRentdate());
		
		//vo.setReturndate(date);
		
		System.out.println(vo.getReturndate());
		System.out.println("date ���� �� __");
		
		return "cart/cartList";
	}
	
	
	
	
	
	
	
	
	
	/*
	
	//02. �뿩 ��� ������
	@RequestMapping("rent_list.do")
	public String memberManage() {
		
		return "rent/rent_list";
	}
	*/
	
	
	
	@RequestMapping("list21.do")
	public String  getListPage(Model model, @RequestParam("num") int num) {
		
		 // �Խù� �� ����
		 int count = cartService.count();
		  
		 System.out.println("num��1"+num);
		 
		 // �� �������� ����� �Խù� ����
		 int postNum = 10;
		  
		 // �ϴ� ����¡ ��ȣ ([ �Խù� �� ���� �� �� �������� ����� ���� ]�� �ø�)
		 int pageNum = (int)Math.ceil((double)count/postNum);
		  
		 // ����� �Խù�
		 int displayPost = (num - 1) * postNum;
		    
		 
		 
		 
		// �ѹ��� ǥ���� ����¡ ��ȣ�� ����
		 int pageNum_cnt = 10;

		 // ǥ�õǴ� ������ ��ȣ �� ������ ��ȣ
		 int endPageNum = (int)(Math.ceil((double)num / (double)pageNum_cnt) * pageNum_cnt);

		 // ǥ�õǴ� ������ ��ȣ �� ù��° ��ȣ
		 int startPageNum = endPageNum - (pageNum_cnt - 1);
		 
		 
		 
		 
		 // ������ ��ȣ ����
		 int endPageNum_tmp = (int)(Math.ceil((double)count / (double)pageNum_cnt));
		 
		 if(endPageNum > endPageNum_tmp) {
		  endPageNum = endPageNum_tmp;
		 }
		 
		 
		 boolean prev = startPageNum == 1 ? false : true;
		 boolean next = endPageNum * pageNum_cnt >= count ? false : true;
		 
		 
		 
		 
		// ���� �� �� ��ȣ
		 model.addAttribute("startPageNum", startPageNum);
		 model.addAttribute("endPageNum", endPageNum);

		 
		 // ���� �� ���� 
		 model.addAttribute("prev", prev);
		 model.addAttribute("next", next);
		 
		 
		 
		 
		 List list = null; 
		 list = cartService.listCartPage(displayPost, postNum);
		 model.addAttribute("list", list);   
		 model.addAttribute("pageNum", pageNum);
		 
		 return "cart/rent_list";
	}
	
	
	
	
	
	
	
	


	//02. �뿩���
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

		System.out.println(calDates);						// �ð� ����
		System.out.println(sdf.format(cal.getTime()));		// �뿩�� +2 = �ݳ���
		
		System.out.println(sdf.format(cal2.getTime()));		// ����ð�
		*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		return "cart/rent_list";
	}

	
}
	
	
	
	

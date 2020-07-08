package com.example.spring01.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.domain.MemberVO;
import com.example.spring01.domain.MovieVO;
import com.example.spring01.service.MemberService;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	
	
	@Inject
	MemberService memberService;
	
	// 02_01. 회원관리 페이지 이동
		@RequestMapping("manage.do")
		public String memberManage() {
			
			return "member/manage";
		}
		
	
	// 회원 관리 페이지 이동
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue="userName") String searchOption,
			@RequestParam(defaultValue="") String keyword) throws Exception{
		

		
		
		
		List<MemberVO> list = memberService.listAll(searchOption, keyword);
		
		ModelAndView mav = new ModelAndView();
		
		// 데이터를 맵에 저장
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		mav.addObject("map", map);
		
		mav.setViewName("member/member_list");
		
		
		return mav;
	}
	
	
	
	
	
	
	// 02_01. 회원등록 페이지로 이동
	@RequestMapping("member/write.do")
	public String memberWrite() {
		
		return "member/member_write";
	}
	
	
	// 02_02. 회원 등록
	@RequestMapping("member/insert.do")
	// * 폼에서 입력한 데이터를 받아오는 법 3가지
	//public String memberInsert(HttpServlet request){
	//public String memberInsert(String userId, String userPw, String userName, String userEmail){
	// 커맨드 객체 (하지만 이 프로젝트에서는 안씀 ) 
	
	public String memberInsert(@ModelAttribute MemberVO vo){
		// 
		memberService.insertMember(vo);
		// * (/)
		// /member/list.do : 
		// member/list.do : 
		// member_list.jsp
		System.out.println("이름:"+vo.getUserName());
		return "redirect:/member/list.do";
	}
	
	
	// 03 회원 상세정보
	@RequestMapping("view.do")
	public String memberView(@RequestParam String userId, Model model) {
		
		model.addAttribute("dto",memberService.viewMember(userId));
		
		
		return "member/member_view";
	}
	
	
	// 04. 회원 정보 수정 처리
	@RequestMapping("member/update.do")
	public String memberUpdate(@ModelAttribute MemberVO vo, Model model){
		// 비밀번호 체크
		boolean result = memberService.checkPw(vo.getUserId(), vo.getUserPass());
		if(result){ // 비밀번호가 일치하면 수정 처리후, 전체 회원 목록으로 리다이렉트
			memberService.updateMember(vo);
			MemberVO vo2 = memberService.viewMember(vo.getUserId());
			vo.setRegDate(vo2.getRegDate());
			model.addAttribute("dto", vo);
			return "member/member_view";
		} else { // 비밀번호가 일치하지 않는다면, div에 불일치 문구 출력, viwe.jsp로 포워드
			// 가입일자, 수정일자 저장
			MemberVO vo2 = memberService.viewMember(vo.getUserId());
			vo.setRegDate(vo2.getRegDate());
			model.addAttribute("dto", vo);
			model.addAttribute("message", "비밀번호 불일치");
			return "member/member_view";
		}
		
	}
	
	
	
	// 05. 회원정보 삭제 처리
			// @RequestMapping : url mapping
			// @RequestParam : get or post방식으로 전달된 변수값
			@RequestMapping("member/delete.do")
			public String memberDelete(@RequestParam String userId, @RequestParam String userPass, Model model){
				// 비밀번호 체크
				boolean result = memberService.checkPw(userId, userPass);
				if(result){ // 비밀번호가 맞다면 삭제 처리후, 전체 회원 목록으로 리다이렉트
					memberService.deleteMember(userId);
					return "redirect:/member/list.do";
				} else { // 비밀번호가 일치하지 않는다면, div에 불일치 문구 출력, viwe.jsp로 포워드
					model.addAttribute("message", "비밀번호 불일치");
					model.addAttribute("dto", memberService.viewMember(userId));
					return "member/member_view";
				}
			}
	
	// 06_01. 로그인 화면 페이지로 이동
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	// 06_02. 로그인 처리
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
		
		boolean result = memberService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if(result == true) {
			
			
			mav.setViewName("main");	// 로그인 성공 -> main.jsp로 이동
			mav.addObject("msg","success");
			
			
			
		}else {
			mav.setViewName("member/login");	//로그인 실패 -> member/login.jsp로 이동
			mav.addObject("msg", "failure");
		}
		return mav;
	}
	
	@RequestMapping("logout.do")
	public ModelAndView logout(HttpSession session) {
		memberService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("member/login");
		mav.addObject("msg","logout");
		
		return mav;
		
	}
	
	
}

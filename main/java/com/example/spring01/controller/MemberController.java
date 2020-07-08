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
	
	// 02_01. ȸ������ ������ �̵�
		@RequestMapping("manage.do")
		public String memberManage() {
			
			return "member/manage";
		}
		
	
	// ȸ�� ���� ������ �̵�
	@RequestMapping("list.do")
	public ModelAndView list(@RequestParam(defaultValue="userName") String searchOption,
			@RequestParam(defaultValue="") String keyword) throws Exception{
		

		
		
		
		List<MemberVO> list = memberService.listAll(searchOption, keyword);
		
		ModelAndView mav = new ModelAndView();
		
		// �����͸� �ʿ� ����
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		mav.addObject("map", map);
		
		mav.setViewName("member/member_list");
		
		
		return mav;
	}
	
	
	
	
	
	
	// 02_01. ȸ����� �������� �̵�
	@RequestMapping("member/write.do")
	public String memberWrite() {
		
		return "member/member_write";
	}
	
	
	// 02_02. ȸ�� ���
	@RequestMapping("member/insert.do")
	// * ������ �Է��� �����͸� �޾ƿ��� �� 3����
	//public String memberInsert(HttpServlet request){
	//public String memberInsert(String userId, String userPw, String userName, String userEmail){
	// Ŀ�ǵ� ��ü (������ �� ������Ʈ������ �Ⱦ� ) 
	
	public String memberInsert(@ModelAttribute MemberVO vo){
		// 
		memberService.insertMember(vo);
		// * (/)
		// /member/list.do : 
		// member/list.do : 
		// member_list.jsp
		System.out.println("�̸�:"+vo.getUserName());
		return "redirect:/member/list.do";
	}
	
	
	// 03 ȸ�� ������
	@RequestMapping("view.do")
	public String memberView(@RequestParam String userId, Model model) {
		
		model.addAttribute("dto",memberService.viewMember(userId));
		
		
		return "member/member_view";
	}
	
	
	// 04. ȸ�� ���� ���� ó��
	@RequestMapping("member/update.do")
	public String memberUpdate(@ModelAttribute MemberVO vo, Model model){
		// ��й�ȣ üũ
		boolean result = memberService.checkPw(vo.getUserId(), vo.getUserPass());
		if(result){ // ��й�ȣ�� ��ġ�ϸ� ���� ó����, ��ü ȸ�� ������� �����̷�Ʈ
			memberService.updateMember(vo);
			MemberVO vo2 = memberService.viewMember(vo.getUserId());
			vo.setRegDate(vo2.getRegDate());
			model.addAttribute("dto", vo);
			return "member/member_view";
		} else { // ��й�ȣ�� ��ġ���� �ʴ´ٸ�, div�� ����ġ ���� ���, viwe.jsp�� ������
			// ��������, �������� ����
			MemberVO vo2 = memberService.viewMember(vo.getUserId());
			vo.setRegDate(vo2.getRegDate());
			model.addAttribute("dto", vo);
			model.addAttribute("message", "��й�ȣ ����ġ");
			return "member/member_view";
		}
		
	}
	
	
	
	// 05. ȸ������ ���� ó��
			// @RequestMapping : url mapping
			// @RequestParam : get or post������� ���޵� ������
			@RequestMapping("member/delete.do")
			public String memberDelete(@RequestParam String userId, @RequestParam String userPass, Model model){
				// ��й�ȣ üũ
				boolean result = memberService.checkPw(userId, userPass);
				if(result){ // ��й�ȣ�� �´ٸ� ���� ó����, ��ü ȸ�� ������� �����̷�Ʈ
					memberService.deleteMember(userId);
					return "redirect:/member/list.do";
				} else { // ��й�ȣ�� ��ġ���� �ʴ´ٸ�, div�� ����ġ ���� ���, viwe.jsp�� ������
					model.addAttribute("message", "��й�ȣ ����ġ");
					model.addAttribute("dto", memberService.viewMember(userId));
					return "member/member_view";
				}
			}
	
	// 06_01. �α��� ȭ�� �������� �̵�
	@RequestMapping("login.do")
	public String login() {
		return "member/login";
	}
	
	// 06_02. �α��� ó��
	@RequestMapping("loginCheck.do")
	public ModelAndView loginCheck(@ModelAttribute MemberVO vo, HttpSession session) {
		
		boolean result = memberService.loginCheck(vo, session);
		ModelAndView mav = new ModelAndView();
		if(result == true) {
			
			
			mav.setViewName("main");	// �α��� ���� -> main.jsp�� �̵�
			mav.addObject("msg","success");
			
			
			
		}else {
			mav.setViewName("member/login");	//�α��� ���� -> member/login.jsp�� �̵�
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

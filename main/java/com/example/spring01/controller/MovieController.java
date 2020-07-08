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
import com.example.spring01.service.MovieServiceImpl;

@Controller
@RequestMapping("/movie/*")
public class MovieController {
	
	
	@Inject
	MovieServiceImpl movieService;
	
	/*
	// 01. ��ȭ ���
	@RequestMapping("movie/list.do")
	public String movieList(Model model) {
		
		List<MovieVO> list = movieService.movieList();  
		model.addAttribute("list",list);
		
		
		
		return "movie/movie_list";
	}
	
	*/
	
	// 01_01. ���� ���� ������ �̵�
	@RequestMapping("manage.do")
	public String memberManage() {
		
		return "movie/manage";
	}
	
	
	// 01_02. ��ȭ��� (�˻�)
			@RequestMapping("search.do")
			//	@RequestParam(defaultValue="") -> �⺻�� �Ҵ� : ���� �������� 1�� �ʱ�ȭ
			
			public ModelAndView search(@RequestParam(defaultValue="movie") String searchOption,
					@RequestParam(defaultValue="") String keyword) throws Exception{
				

				List<MovieVO> list = movieService.movieList(searchOption, keyword);
				
				
				System.out.println(list.get(2).getGrade());
				System.out.println(list.get(3).getGrade());
				
				
				ModelAndView mav = new ModelAndView();
				
				// �����͸� �ʿ� ����
				
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("list", list);
				map.put("searchOption", searchOption);
				map.put("keyword", keyword);
				
				
				mav.addObject("map", map);
				
				/*
				System.out.println("map"+map);
				System.out.println("map.get(list)"+map.get("list"));
				
				List<MovieVO> tp1 = (List<MovieVO>)map.get("list");
				
				System.out.println("tp1: "+tp1);
				System.out.println("tp1.get(0): "+tp1.get(0));
				
				// map-> list -> movieVO
				System.out.print(tp1.get(0).getMovie());
				*/
				
				
				mav.setViewName("movie/movie2_list");
				
				
				return mav;
			}
	
			
			@RequestMapping("search2.do")
			//	@RequestParam(defaultValue="") -> �⺻�� �Ҵ� : ���� �������� 1�� �ʱ�ȭ
			
			public ModelAndView search2(@RequestParam(defaultValue="movie") String searchOption,
					@RequestParam(defaultValue="") String keyword) throws Exception{
				

				List<MovieVO> list = movieService.movieList(searchOption, keyword);
				
				ModelAndView mav = new ModelAndView();
				
				// �����͸� �ʿ� ����
				
				Map<String,Object> map = new HashMap<String, Object>();
				map.put("list", list);
				map.put("searchOption", searchOption);
				map.put("keyword", keyword);
				
				
				mav.addObject("map", map);
				
				/*
				System.out.println("map"+map);
				System.out.println("map.get(list)"+map.get("list"));
				
				List<MovieVO> tp1 = (List<MovieVO>)map.get("list");
				
				System.out.println("tp1: "+tp1);
				System.out.println("tp1.get(0): "+tp1.get(0));
				
				// map-> list -> movieVO
				System.out.print(tp1.get(0).getMovie());
				*/
				
				
				mav.setViewName("movie/movie3_list");
				
				
				return mav;
			}
			
	
			
			
			//02. ��ȭ �󼼺���
			@RequestMapping("movie2_view.do")
			public String movie2View(@RequestParam String mno, Model model){
				// ȸ�� ������ model�� ����
				//             �� �Ӽ� ����,  �Ӽ� �� ����
				//model.addAttribute("dto", movieService.viewMovie(mno)); //viewMember(userId));
				//System.out.println(" : "+userId);
				
				model.addAttribute("dto", movieService.view2Movie(mno));
				System.out.println(model.toString());
				
				
				
				// member_view.jsp
				return "movie/movie2_view";
			}
			
			
			
			@RequestMapping("movie2_select.do")
			public String movieSelect(@RequestParam String mno, Model model) {
				
				model.addAttribute("dto", movieService.select2Movie(mno));
				
				
				
				return "movie/movie2_select";
			}
			
			
			
			
			
			
			
			
			//02. ��ȭ����
			@RequestMapping("movie2_update.do")
			public String movieUpdate(@ModelAttribute MovieVO vo, Model model){
				System.out.println("1");
				System.out.println(vo.getGrade());
				movieService.updateMovie(vo);				
				System.out.println("2");
				model.addAttribute("dto", vo);
				return "redirect:/movie/manage.do";
				
			}
			
			
			//03. ��ȭ ����
			@RequestMapping("movie2_delete.do")
			public String movieDelete(@ModelAttribute MovieVO vo, Model model) {
				
				System.out.println("3");
				System.out.println(vo.getMno());
				movieService.deleteMovie(vo);
				return "movie/movie2_list";
			}
			
			
			
			
			
			
			
			
			
			
			
	// 01_02. ������� (�˻�)
	@RequestMapping("list.do")
	//	@RequestParam(defaultValue="") -> �⺻�� �Ҵ� : ���� �������� 1�� �ʱ�ȭ
	public ModelAndView list(@RequestParam(defaultValue="movie") String searchOption,
			@RequestParam(defaultValue="") String keyword) throws Exception{
		

		
		
		
		List<MovieVO> list = movieService.listAll(searchOption, keyword);
		
		//System.out.println(list.get(0).getMovie());		�̸� ������ 
		
		ModelAndView mav = new ModelAndView();
		
		// �����͸� �ʿ� ����
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("list", list);
		map.put("searchOption", searchOption);
		map.put("keyword", keyword);
		
		
		mav.addObject("map", map);
		
		mav.setViewName("movie/movie_list");
		
		
		return mav;
	}
	
	
	
	
	//02. ���� �󼼺���
	@RequestMapping("movie_view.do")
	public String movieView(@RequestParam String vno, Model model){
		// ȸ�� ������ model�� ����
		//             �� �Ӽ� ����,  �Ӽ� �� ����
		model.addAttribute("dto", movieService.viewMovie(vno)); //viewMember(userId));
		//System.out.println(" : "+userId);
		
		System.out.println(vno);
		
		// member_view.jsp
		return "movie/movie_view";
	}
	
	
	
	
	
	// 02_01. ��ȭ��� �������� �̵�
	@RequestMapping("movie/write.do")
	public String memberWrite() {
		
		return "movie/movie_write";
	}
	
	
	
	
	// 02_02. ��ȭ ���
	@RequestMapping("movie/insert.do")
	// * ������ �Է��� �����͸� �޾ƿ��� �� 3����
	//public String memberInsert(HttpServlet request){
	//public String memberInsert(String userId, String userPw, String userName, String userEmail){
	// Ŀ�ǵ� ��ü 
	
	public String movieInsert(@ModelAttribute MovieVO vo){
		// 
		movieService.insertMovie(vo);
		
		System.out.println("�̸�:"+vo.getMovie());
		System.out.println("���:"+vo.getGrade());
		
		// * (/)
		// /member/list.do : 
		// member/list.do : 
		// member_list.jsp
		return "movie/manage";
	}
	
	
	
	
	
	// 02_03. ���� ��� �������� �̵�
	@RequestMapping("movie/video_write.do")
	public String videoWrite() {
		
		return "movie/movie3_list";
	}
	
	
	
	// 02_04. ���� ���
	@RequestMapping("movie/video_insert.do")
	// * ������ �Է��� �����͸� �޾ƿ��� �� 3����
	//public String memberInsert(HttpServlet request){
	//public String memberInsert(String userId, String userPw, String userName, String userEmail){
	// Ŀ�ǵ� ��ü (������ �� ������Ʈ������ �Ⱦ� ) 
	
	public String videoInsert(@ModelAttribute MovieVO vo){
		// 
		//movieService.insertMovie(vo);
		movieService.insertVideo(vo);
		
		System.out.println("��ȭ:"+vo.getMno());
		System.out.println("����:"+vo.getVno());
		System.out.println("��ȭ:"+vo.getMovie());
		
		// * (/)
		// /member/list.do : 
		// member/list.do : 
		// member_list.jsp
		return "movie/movie_list";
	}
	
	
	
	
	
}





















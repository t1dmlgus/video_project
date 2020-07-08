package com.example.spring01.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	// ���������� mapping ����
		@RequestMapping("/")
		public String main(Model model){
			// model : �����͸� ��� �׸� ����, map������ ����ȴ�.
			// model.addAttribute("������", ��);
			model.addAttribute("msg", "Ȩ������ �������");
			return "main"; // main.jsp�� ������
		}
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate =  dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home_back";
	}
	
}

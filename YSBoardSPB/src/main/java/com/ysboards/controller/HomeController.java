package com.ysboards.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public ModelAndView home() {
		System.out.println("[HomeController] /");
		ModelAndView mav = new ModelAndView("redirect:/board/boards");
		
		return mav;
	}
}

package com.example.demo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {


//	public ModelAndView home (@RequestParam("name") String myname) {
//		
////		HttpSession session = req.getSession();
////		String name = req.getParameter("name");
////		session.setAttribute("name", myname);
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("name",myname);
//		mv.setViewName("Home");
//		return mv;
//	}
	@RequestMapping("home")
	public ModelAndView home (Alien alien) {
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("obj", alien);
		mv.setViewName("Home");
		return mv;
	}
}

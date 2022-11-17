 package com.rail.reserve.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rail.reserve.HomeController;
import com.rail.reserve.model.MemberService;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public ModelAndView join() {
		return new ModelAndView("member/Join");
	}
	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public ModelAndView join(@RequestParam Map<String,Object> map) {
		try {
			ModelAndView mav = new ModelAndView();
			boolean isCreated = service.join(map);
			if(isCreated) {
				mav.setViewName("redirect:/");
			}else {
				mav.setViewName("redirect:/join");
			}
			return mav;
		} catch (DuplicateKeyException e) {
				ModelAndView mav = new ModelAndView("member/Join_fail");	
				return mav;
			}
	}
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView("member/login");
		return mav;
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
		public ModelAndView login(@RequestParam Map<String,Object> map, HttpSession session) {
		ModelAndView mav = new ModelAndView("member/login");
		Map<String, Object> result = service.loginCheck(map);
			if (result != null) {
				mav.setViewName("redirect:/");
				session.setAttribute("member", result);
			} else {
				session.setAttribute("member", null);
				mav.addObject("msg", false);
				mav.setViewName("redirect:/login"); 		
			}
			return mav;
			
		}
	

}

package com.rail.reserve.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rail.reserve.HomeController;
import com.rail.reserve.model.MemberService;
import com.rail.reserve.vo.MemberVO;

@Controller
public class MemberController {
	@Autowired
	private MemberService service;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public ModelAndView join() {
		return new ModelAndView("member/join");
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
				ModelAndView mav = new ModelAndView("member/join_fail");	
				return mav;
			}
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login() {
		return new ModelAndView("member/login");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView login(@RequestParam Map<String, Object> map, HttpSession session, @ModelAttribute MemberVO vo) {
		ModelAndView mav = new ModelAndView("reserve/reserve");
		Map<String, Object> result = service.loginCheck(map);
		if (result != null) {
			mav.addObject("member",result);
			session.setAttribute("member", result);
			String member_id = vo.getMember_id();
			if(member_id.equals("admin")) {
				mav.setViewName("redirect:/admin");
			}
			mav.setViewName("redirect:/reserve?member_id="+member_id);
			session.setAttribute("member", result);
			
		} else {
			session.setAttribute("member", null);
			mav.addObject("msg", false);
			mav.setViewName("redirect:/login");
		}
		return mav;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session, ModelAndView mav) {
		service.logout(session);
		mav.addObject("message", "logout");
		mav.setViewName("redirect:/");
		return mav;
	}
	
	@RequestMapping(value = "/admin")
	public ModelAndView admin() {
		ModelAndView mav = new ModelAndView("member/admin");
		return mav;
	}
}

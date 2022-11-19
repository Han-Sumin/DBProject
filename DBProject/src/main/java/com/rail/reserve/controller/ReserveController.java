package com.rail.reserve.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rail.reserve.model.ReserveService;
import com.rail.reserve.vo.ReserveVO;

@Controller
public class ReserveController {
	@Autowired
	private ReserveService service;

	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public ModelAndView reserve(@RequestParam String MEMBER_ID) {
		ModelAndView mav = new ModelAndView("reserve/reserve");
		return mav;

	}

	@RequestMapping(value = "/reserveseat", method = RequestMethod.GET)
	public ModelAndView reserveseat(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String station_id = request.getParameter("station_id");
		String train_id = request.getParameter("train_id");
		String direction = request.getParameter("direction");
		String time = request.getParameter("time");

		mav.setViewName("/reserveseat?station_id=" + station_id + "&&train_id=" + train_id + "&&direction="
				+ direction);

		return mav;
	}
	

}

package com.rail.reserve.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rail.reserve.HomeController;
import com.rail.reserve.model.ReserveService;
import com.rail.reserve.vo.ReserveVO;
import com.rail.reserve.vo.ReservedSeatVO;
import com.rail.reserve.vo.ScheduleVO;
import com.rail.reserve.vo.TrainSeatVO;

@Controller
public class ReserveController {
	@Autowired
	private ReserveService service;
	private static final Logger logger = LoggerFactory.getLogger(ReserveController.class);

	@RequestMapping(value = "/reserve", method = RequestMethod.GET)
	public ModelAndView reserve(@RequestParam String MEMBER_ID) {
		ModelAndView mav = new ModelAndView("reserve/reserve");
		return mav;

	}

	@RequestMapping(value = "/reserve/reservedstatus", method = RequestMethod.GET)
	public ModelAndView reservestatus() {
		return new ModelAndView("reserve/reservedstatus");

	}

	@RequestMapping(value = "/reserve/reservedstatus", method = RequestMethod.POST)
	public ModelAndView reservestatus(@RequestParam Map<String, Object> map, @ModelAttribute ReserveVO vo,
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		String start = vo.getSTART_STATION();
		String arrival = vo.getARRIVAL_STATION();
		int start_num = Integer.parseInt(start);
		int arrival_num = Integer.parseInt(arrival);
		int num = Math.abs(start_num - arrival_num);
		vo.setPRICE(num * 1000);
		service.reservestatus(vo);
		String train_id = request.getParameter("TRAIN_ID");
		String member_id = vo.getMEMBER_ID();
		mav.setViewName("redirect:/reserve/reserveseat?RESERVE_ID=" + vo.getRESERVE_ID() + "&&TRAIN_ID=" + train_id
				+ "&&TRAIN_NUM=1&&MEMBER_ID=" + member_id);
		return mav;
	}

	@RequestMapping(value = "/reserve/reserveseat", method = RequestMethod.GET)
	public ModelAndView reserveseat(@RequestParam Map<String, Object> map, @ModelAttribute TrainSeatVO vo) {
		String TRAIN_ID = vo.getTRAIN_ID();
		String TRAIN_NUM = vo.getTRAIN_NUM();
		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("TRAIN_ID", TRAIN_ID);
		map2.put("TRAIN_NUM", TRAIN_NUM);
		List<Map<String, Object>> lists = service.seatlists(map2);
		ModelAndView mav = new ModelAndView("reserve/reserveseat");
		mav.addObject("lists", lists);
		return mav;
	}

	@RequestMapping(value = "/reserve/reserveseat", method = RequestMethod.POST)
	public ModelAndView reserveseat(@RequestParam Map<String, Object> map, @ModelAttribute ReservedSeatVO vo,
			@RequestParam(value = "SEAT_NUM", required = false) String[] seats, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int RESERVE_ID = vo.getRESERVE_ID();
		String train_id = vo.getTRAIN_ID();
		String start = service.start(RESERVE_ID);
		String end = service.end(RESERVE_ID);
		String member_id = request.getParameter("MEMBER_ID");
		int seat_count = seats.length;
		int max = 0;
		int min = 0;
		int start_num = Integer.parseInt(start);
		int end_num = Integer.parseInt(end);
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("TRAIN_ID", train_id);
		map3.put("START_STATION", start);
		map3.put("ARRIVAL_STATION", end);
		String strcost = service.cost(map3);
		int cost = Integer.parseInt(strcost);
		cost = cost * seat_count;
		if (start_num > end_num) {
			max = start_num;
			min = end_num;
			vo.setDIRECTION("상행");
		} else {
			max = end_num;
			min = start_num;
			vo.setDIRECTION("하행");
		}
		for (int i = min; i <= max; i++) {
			for (int number = 0; number < seats.length; number++) {
				String j = String.valueOf(i);
				vo.setSTATION_ID(j);
				vo.setSEAT_NUM(seats[number]);
				String TIME = service.timeget(vo);
				vo.setTIME(TIME);
				int count = service.count(vo);
				System.out.println(count);
				if (count == 0) {
					service.insertseat(vo);
					mav.setViewName(
							"redirect:/pay?MEMBER_ID=" + member_id + "&&RESERVE_ID=" + RESERVE_ID + "&&START_STATION="
									+ start + "&&ARRIVAL_STATION=" + end + "&&TRAIN_ID=" + train_id + "&&PRICE=" + cost);
				} else {
					service.delete(RESERVE_ID);
					mav.setViewName("redirect:/reserve/reserve_fail?MEMBER_ID=" + member_id);
				}
			}

		}

return mav;
	}

	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	public ModelAndView reservelists(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		String member_id = request.getParameter("MEMBER_ID");
		String reserve_id = request.getParameter("RESERVE_ID");
		String cost = request.getParameter("COST");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("RESERVE_ID", reserve_id);
		map2.put("MEMBER_ID", member_id);
		List<ReserveVO> lists = service.pay(map2);
		service.updateprice(map);

		ModelAndView mav = new ModelAndView("reserve/pay");

		mav.addObject("lists", lists);
		return mav;

	}

	@RequestMapping(value = "/reserve/reserve_fail", method = RequestMethod.GET)
	public ModelAndView reserve_fail(@RequestParam String MEMBER_ID) {
		ModelAndView mav = new ModelAndView("reserve/reserve_fail");
		return mav;
	}

	@RequestMapping(value = "/reserve/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam Map<String, Object> map, @ModelAttribute ScheduleVO vo,
			HttpServletRequest request) {
		vo.setSTATION_ID(request.getParameter("START_STATION"));
		ModelAndView mav = new ModelAndView("reserve/search");

		List<ScheduleVO> lists = service.search(vo);
		mav.addObject("lists", lists);
		return mav;
	}
	
	@ExceptionHandler(RuntimeException.class)
	public String exceptionHandler(Model model, Exception e){
	logger.info("exception : " + e.getMessage());
	model.addAttribute("exception", e);
	return "reserve/reserve_fail";

	}

}

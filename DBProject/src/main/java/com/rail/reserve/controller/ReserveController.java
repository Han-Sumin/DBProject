package com.rail.reserve.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.rail.reserve.model.ReserveService;
import com.rail.reserve.vo.ReserveVO;
import com.rail.reserve.vo.ReservedSeatVO;
import com.rail.reserve.vo.TrainSeatVO;

@Controller
public class ReserveController {
	@Autowired
	private ReserveService service;

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
		Date date = new Date();
		int start_num = Integer.parseInt(start);
		int arrival_num = Integer.parseInt(arrival);
		int num = Math.abs(start_num - arrival_num);
		vo.setPRICE(num * 1000);
		service.reservestatus(vo);
		int reserve_id = service.getreserveid(vo);
		vo.setRESERVE_ID(reserve_id);
		String train_id = request.getParameter("TRAIN_ID");
		String member_id = vo.getMEMBER_ID();
		mav.setViewName("redirect:/reserve/reserveseat?RESERVE_ID=" + reserve_id + "&&TRAIN_ID=" + train_id
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
			HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int RESERVE_ID = vo.getRESERVE_ID();
		String train_id = vo.getTRAIN_ID();
		String start = service.start(RESERVE_ID);
		String end = service.end(RESERVE_ID);
		String member_id = request.getParameter("MEMBER_ID");
		int max = 0;
		int min = 0;
		int start_num = Integer.parseInt(start);
		int end_num = Integer.parseInt(end);
		Map<String, String> map3 = new HashMap<String, String>();
		map3.put("TRAIN_ID", train_id);
		map3.put("START_STATION", start);
		map3.put("ARRIVAL_STATION", end);
		String cost = service.cost(map3);
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
			String j = String.valueOf(i);
			vo.setSTATION_ID(j);
			Boolean isinsert = service.insertseat(vo);

			if (isinsert) {
				mav.setViewName(
						"redirect:/pay?MEMBER_ID=" + member_id + "&&RESERVE_ID=" + RESERVE_ID + "&&START_STATION="
								+ start + "&&ARRIVAL_STATION=" + end + "&&TRAIN_ID=" + train_id + "&&COST=" + cost);
			} else {
				mav.setViewName("redirect:/");
			}

		}

		return mav;

	}

	@RequestMapping(value = "/pay", method = RequestMethod.GET)
	public ModelAndView reservelists(@RequestParam Map<String, Object> map, HttpServletRequest request) {
		String member_id = request.getParameter("MEMBER_ID");
		String reserve_id = request.getParameter("RESERVE_ID");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("RESERVE_ID", reserve_id);
		map2.put("MEMBER_ID", member_id);
		List<ReserveVO> lists = service.pay(map2);

		ModelAndView mav = new ModelAndView("reserve/pay");

		mav.addObject("lists", lists);
		return mav;

	}

	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		return new ModelAndView("reserve/reserve_fail");
	}

}

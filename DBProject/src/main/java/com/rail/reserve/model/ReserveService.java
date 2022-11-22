package com.rail.reserve.model;

import java.util.List;
import java.util.Map;

import com.rail.reserve.vo.ReserveVO;
import com.rail.reserve.vo.ReservedSeatVO;
import com.rail.reserve.vo.ScheduleVO;
import com.rail.reserve.vo.TrainSeatVO;

public interface ReserveService {

	List<ReserveVO> reserve();


	void reservestatus(ReserveVO vo);


	List<Map<String, Object>> seatlists(Map<String, String> map2);


	String start(int RESERVE_ID);


	int getreserveid(ReserveVO vo);


	String end(int RESERVE_ID);


	void insertseat(ReservedSeatVO vo);


	List<ReserveVO> pay(Map<String, String> map2);


	String cost(Map<String, String> map3);


	int count(ReservedSeatVO vo);


	void delete(int RESERVE_ID);


	List<ScheduleVO> search(ScheduleVO vo);






}

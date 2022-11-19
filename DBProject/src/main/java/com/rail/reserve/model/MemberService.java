package com.rail.reserve.model;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.rail.reserve.vo.MemberVO;
import com.rail.reserve.vo.TrainVO;

public interface MemberService {

	boolean join(Map<String, Object> map);

	public Map<String, Object> loginCheck(Map<String, Object> map);

	public void logout(HttpSession session);

	List<MemberVO> list();

	void update(Map<String, Object> map);

	List<TrainVO> trainlists();

	void addTrain(Map<String, Object> map);

	List<TrainVO> schedulelists();

	void addSchedule(Map<String, Object> map);

}

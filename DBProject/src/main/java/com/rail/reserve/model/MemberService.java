package com.rail.reserve.model;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.rail.reserve.vo.MemberVO;
import com.rail.reserve.vo.ReserveVO;
import com.rail.reserve.vo.TrainVO;

public interface MemberService {



	public void logout(HttpSession session);

	List<MemberVO> list();

	void update(Map<String, Object> map);

	List<TrainVO> trainlists();

	void addTrain(Map<String, Object> map);

	List<TrainVO> schedulelists();

	void addSchedule(Map<String, Object> map);

	List<MemberVO> mypage(String MEMBER_ID);

	void nameupdate(Map<String, Object> map);

	void phoneupdate(Map<String, Object> map);

	void cardupdate(Map<String, Object> map);

	void deletemember(Map<String, Object> map);

	List<ReserveVO> reservelists(String MEMBER_ID);


	void deleteseat(Map<String, Object> map);

	void deletestatus(Map<String, Object> map);

	boolean join(MemberVO vo);

	public Map<String, Object> loginCheck(MemberVO vo);

	public void updatestate(String MEMBER_ID);


	public String state(MemberVO vo);

}

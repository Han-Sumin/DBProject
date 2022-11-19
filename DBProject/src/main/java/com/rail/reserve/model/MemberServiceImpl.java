package com.rail.reserve.model;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rail.reserve.dao.MemberDao;
import com.rail.reserve.vo.MemberVO;
import com.rail.reserve.vo.TrainVO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDao dao;

	@Override
	public boolean join(Map<String, Object> map) {
		int result = dao.join(map);	
		return result == 1;
	}

	@Override
	public Map<String, Object> loginCheck(Map<String, Object> map) {
		Map<String, Object> name = dao.loginCheck(map);
		return name;
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public List<MemberVO> list() {
		// TODO Auto-generated method stub
		return dao.memberlists();
	}

	@Override
	public void update(Map<String, Object> map) {
		dao.gradeUpdate(map);
		
	}

	@Override
	public List<TrainVO> trainlists() {
		// TODO Auto-generated method stub
		return dao.trainlists();
	}

	@Override
	public void addTrain(Map<String, Object> map) {
		dao.addTrain(map);
		
	}

	@Override
	public List<TrainVO> schedulelists() {
		// TODO Auto-generated method stub
		return dao.schedulelists();
	}

	@Override
	public void addSchedule(Map<String, Object> map) {
		dao.addSchedule(map);
		
	}

	




}

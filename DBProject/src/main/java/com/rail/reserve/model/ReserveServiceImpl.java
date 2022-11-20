package com.rail.reserve.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rail.reserve.dao.ReserveDao;
import com.rail.reserve.vo.ReserveVO;
import com.rail.reserve.vo.ReservedSeatVO;

@Service
public class ReserveServiceImpl implements ReserveService {
	
	@Autowired
	private ReserveDao dao;

	@Override
	public List<ReserveVO> reserve() {
		return dao.reserve();
	}


	@Override
	public void reservestatus(ReserveVO vo) {
		dao.reservestatus(vo);
		
	}


	@Override
	public List<Map<String, Object>> seatlists(Map<String, String> map2) {
		// TODO Auto-generated method stub
		return dao.seatlists(map2);
	}


	@Override
	public String start(int RESERVE_ID) {
		// TODO Auto-generated method stub
		return dao.start(RESERVE_ID);
	}


	@Override
	public int getreserveid(ReserveVO vo) {
		// TODO Auto-generated method stub
		return dao.getreserveid(vo);
	}


	@Override
	public String end(int RESERVE_ID) {
		// TODO Auto-generated method stub
		return dao.end(RESERVE_ID);
	}


	@Override
	public Boolean insertseat(ReservedSeatVO vo) {
		// TODO Auto-generated method stub
		int result = dao.insertseat(vo);
		return result == 1;
	}


	@Override
	public List<ReserveVO> pay(Map<String, String> map2) {
		// TODO Auto-generated method stub
		return dao.pay(map2);
	}


	@Override
	public String cost(Map<String, String> map3) {
		// TODO Auto-generated method stub
		return dao.cost(map3);
	}






}

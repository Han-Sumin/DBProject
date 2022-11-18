package com.rail.reserve.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rail.reserve.dao.ReserveDao;
import com.rail.reserve.vo.ReserveVO;

@Service
public class ReserveServiceImpl implements ReserveService {
	
	@Autowired
	private ReserveDao dao;

	@Override
	public List<ReserveVO> reserve() {
		return dao.reserve();
	}

}

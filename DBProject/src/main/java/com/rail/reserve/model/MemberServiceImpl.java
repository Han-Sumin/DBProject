package com.rail.reserve.model;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rail.reserve.dao.MemberDao;
import com.rail.reserve.vo.MemberVO;

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

}

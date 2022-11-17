package com.rail.reserve.model;

import java.util.Map;

import com.rail.reserve.vo.MemberVO;

public interface MemberService {

	boolean join(Map<String, Object> map);

	Map<String, Object> loginCheck(Map<String, Object> map);
	

}

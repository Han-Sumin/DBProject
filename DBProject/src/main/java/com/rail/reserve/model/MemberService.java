package com.rail.reserve.model;

import java.util.Map;

import javax.servlet.http.HttpSession;

import com.rail.reserve.vo.MemberVO;

public interface MemberService {

	boolean join(Map<String, Object> map);

	public Map<String, Object> loginCheck(Map<String, Object> map);

	public void logout(HttpSession session);

}

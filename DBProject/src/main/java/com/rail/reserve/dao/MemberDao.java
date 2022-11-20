package com.rail.reserve.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rail.reserve.vo.MemberVO;
import com.rail.reserve.vo.TrainVO;

import jakarta.servlet.http.HttpSession;

@Repository
public class MemberDao {

	@Autowired
	SqlSessionTemplate sqltemplate;

	public int join(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqltemplate.insert("member.insert", map);
	}

	public Map<String, Object> loginCheck(Map<String, Object> map) {
		return sqltemplate.selectOne("member.login", map);
	}

	public Map<String, Object> logout(HttpSession session) {
		return sqltemplate.selectOne("member.logout", session);
	}

	public List<MemberVO> memberlists() {
		// TODO Auto-generated method stub
		return sqltemplate.selectList("member.lists");
	}

	public Object gradeUpdate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sqltemplate.update("member.gradeUpdate",map);
	}

	public List<TrainVO> trainlists() {
		// TODO Auto-generated method stub
		return sqltemplate.selectList("member.trainlists");
	}

	public void addTrain(Map<String, Object> map) {
		sqltemplate.insert("member.addtrain",map);
		
	}

	public List<TrainVO> schedulelists() {
		// TODO Auto-generated method stub
		return sqltemplate.selectList("member.schedulelists");
	}

	public void addSchedule(Map<String, Object> map) {
		sqltemplate.insert("member.addSchedule",map);
		
	}

	public List<MemberVO> mypage(String MEMBER_ID) {
		// TODO Auto-generated method stub
		return sqltemplate.selectList("member.mypage",MEMBER_ID);
	}

	public void nameupdate(Map<String, Object> map) {
		sqltemplate.update("member.nameupdate",map);
		
	}

	public void phoneupdate(Map<String, Object> map) {
		sqltemplate.update("member.phoneupdate",map);
		
	}

	public void cardupdate(Map<String, Object> map) {
		sqltemplate.update("member.cardupdate",map);
		
	}

	public void deletemember(Map<String, Object> map) {
		sqltemplate.delete("member.delete",map);
		
	}

	

}

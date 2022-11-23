package com.rail.reserve.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rail.reserve.vo.MemberVO;
import com.rail.reserve.vo.ReserveVO;
import com.rail.reserve.vo.TrainVO;

import jakarta.servlet.http.HttpSession;

@Repository
public class MemberDao {

	@Autowired
	SqlSessionTemplate sqltemplate;

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

	public List<ReserveVO> reservelists(String MEMBER_ID) {
		// TODO Auto-generated method stub
		return sqltemplate.selectList("member.reservelists",MEMBER_ID);
	}

	public void updatepay(Map<String, Object> map) {
		sqltemplate.update("member.updatepay",map);
		
	}

	public void deleteseat(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqltemplate.delete("member.deleteseat",map);
	}

	public void deletestatus(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqltemplate.delete("member.deletestatus",map);
	}

	public int join(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqltemplate.insert("member.insert", vo);
	}

	public Map<String, Object> loginCheck(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqltemplate.selectOne("member.login", vo);
	}

	public void updatestate(String MEMBER_ID) {
		sqltemplate.update("member.updatestate",MEMBER_ID);
		
	}

	public String state(MemberVO vo) {
		// TODO Auto-generated method stub
		return sqltemplate.selectOne("member.state",vo);
	}

	

}

package com.rail.reserve.dao;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rail.reserve.vo.ReserveVO;
import com.rail.reserve.vo.ReservedSeatVO;

@Repository
public class ReserveDao {

	@Autowired
	SqlSessionTemplate sqltemplate;

	public List<ReserveVO> reserve() {
		return sqltemplate.selectList("reserve.schedulelists");
	}

	public void reservestatus(ReserveVO vo) {
		sqltemplate.insert("reserve.reservestatus",vo);
		
	}

	public List<Map<String, Object>> seatlists(Map<String, String> map2) {
		// TODO Auto-generated method stub
		return sqltemplate.selectList("reserve.seatlists",map2);
	}

	public String start(int RESERVE_ID) {
		// TODO Auto-generated method stub
		return sqltemplate.selectOne("reserve.start", RESERVE_ID);
	}

	public int getreserveid(ReserveVO vo) {
		// TODO Auto-generated method stub
		return sqltemplate.selectOne("reserve.getreserveid",vo);
	}

	public String end(int RESERVE_ID) {
		// TODO Auto-generated method stub
		return sqltemplate.selectOne("reserve.end",RESERVE_ID);
	}

	public void insertseat(ReservedSeatVO vo) {
		// TODO Auto-generated method stub
		sqltemplate.insert("reserve.insertseat",vo);
	}

	public List<ReserveVO> pay(Map<String, String> map2) {
		// TODO Auto-generated method stub
		return sqltemplate.selectList("reserve.pay",map2);
	}

	public String cost(Map<String, String> map3) {
		// TODO Auto-generated method stub
		return sqltemplate.selectOne("reserve.cost",map3);
	}

	public int count(ReservedSeatVO vo) {
		// TODO Auto-generated method stub
		return sqltemplate.selectOne("reserve.count",vo) ;
	}

	public void delete(int RESERVE_ID) {
		// TODO Auto-generated method stub
		sqltemplate.delete("reserve.delete",RESERVE_ID);
	}


}

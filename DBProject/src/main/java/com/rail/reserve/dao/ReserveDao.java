package com.rail.reserve.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rail.reserve.vo.ReserveVO;

@Repository
public class ReserveDao {

	@Autowired
	SqlSessionTemplate sqltemplate;

	public List<ReserveVO> reserve() {
		return sqltemplate.selectList("reserve.schedulelists");
	}
}

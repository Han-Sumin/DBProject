package com.rail.reserve.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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

}

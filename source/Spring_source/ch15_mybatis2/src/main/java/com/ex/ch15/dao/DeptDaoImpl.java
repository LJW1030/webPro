package com.ex.ch15.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ex.ch15.vo.Dept;
@Repository
public class DeptDaoImpl implements DeptDao {
	@Autowired
	private SqlSession sessionTemplate;
	@Override
	public List<Dept> deptList() {
		return sessionTemplate.selectList("deptList");
	}

}

package com.ex.ch14.dao;

import java.util.List;

import com.ex.ch14.dto.Emp;

public interface EmpDao {
	public List<Emp> empList(Emp schEmp);
}

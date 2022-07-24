package com.ex.ch15.dao;

import java.util.List;

import com.ex.ch15.vo.Emp;

public interface EmpDao {
	public List<Emp> empList();
	public List<Emp> empDeptList(Emp emp);
	public int totCnt();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
}

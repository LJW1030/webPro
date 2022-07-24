package com.ex.ch15.service;

import java.util.List;

import com.ex.ch15.vo.Dept;
import com.ex.ch15.vo.Emp;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(String pageNum);
	public List<Emp> empDeptList(String pageNum);
	public int totCnt();
	public Emp detail(int empno);
	public List<Emp> managerList();
	public int insert(Emp emp);
	public int update(Emp emp);
	public int delete(int empno);
	public void dummyDataInsert();
}

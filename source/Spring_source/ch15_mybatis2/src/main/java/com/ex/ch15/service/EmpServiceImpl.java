package com.ex.ch15.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.ch15.dao.DeptDao;
import com.ex.ch15.dao.EmpDao;
import com.ex.ch15.util.Paging;
import com.ex.ch15.vo.Dept;
import com.ex.ch15.vo.Emp;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private DeptDao deptDao;
	@Autowired
	private EmpDao empDao;
	
	@Override
	public List<Dept> deptList() {
		return deptDao.deptList();
	}

	@Override
	public List<Emp> empList(String pageNum) {
		Paging paging = new Paging(empDao.totCnt(), pageNum, 10, 5);
		Emp emp = new Emp();
		emp.setStartRow(paging.getStartRow());
		emp.setEndRow(paging.getEndRow());
		return empDao.empList();
	}

	@Override
	public List<Emp> empDeptList(String pageNum) {
		Paging paging = new Paging(empDao.totCnt(), pageNum, 10, 5);
		Emp emp = new Emp();
		emp.setStartRow(paging.getStartRow());
		emp.setEndRow(paging.getEndRow());
		return empDao.empDeptList(emp);
	}

	@Override
	public int totCnt() {
		return empDao.totCnt();
	}

	@Override
	public Emp detail(int empno) {
		return empDao.detail(empno);
	}

	@Override
	public List<Emp> managerList() {
		return empDao.managerList();
	}

	@Override
	public int insert(Emp emp) {
		return empDao.insert(emp);
	}

	@Override
	public int update(Emp emp) {
		return empDao.update(emp);
	}

	@Override
	public int delete(int empno) {
		return empDao.delete(empno);
	}

	@Override
	public void dummyDataInsert() {
		Emp emp = new Emp();
		for(int i=5000; i<5050; i++) {
			emp.setEmpno(i);
			emp.setEname("Lee"+i);
			emp.setJob("IT");
			emp.setMgr(7566);
			emp.setHiredate(Timestamp.valueOf("2022-07-21 14:00:00"));
			emp.setSal(i);
			emp.setComm(i/10);
			emp.setDeptno(40);
			int result = empDao.insert(emp);
			System.out.println(result==1 ? i+"번째 회원" : i+"번 실패");
		}
	}

}

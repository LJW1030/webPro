package com.ex.ch14.Service;

import java.util.List;

import com.ex.ch14.dto.Dept;
import com.ex.ch14.dto.Emp;

public interface EmpService {
	public List<Dept> deptList();
	public List<Emp> empList(Emp schEmp);
}

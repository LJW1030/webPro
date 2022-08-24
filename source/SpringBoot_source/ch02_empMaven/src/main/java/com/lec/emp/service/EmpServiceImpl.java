package com.lec.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lec.emp.domain.Dept;
import com.lec.emp.domain.Emp;
import com.lec.emp.repository.DeptRepository;
import com.lec.emp.repository.EmpRepository;
@Service
public class EmpServiceImpl implements EmpService {
	@Autowired
	private EmpRepository empR;
	@Autowired
	private DeptRepository deptR;

	@Override
	public List<Dept> deptList() {
		return deptR.deptList();
	}

	@Override
	public List<Emp> empList(Emp searchEmp) {
		if(searchEmp.getEname()!=null) {
			searchEmp.setEname(searchEmp.getEname().toUpperCase());
		}
		if(searchEmp.getJob()!=null) {
			searchEmp.setJob(searchEmp.getJob().toUpperCase());
		}
		return empR.empList(searchEmp);
	}

}

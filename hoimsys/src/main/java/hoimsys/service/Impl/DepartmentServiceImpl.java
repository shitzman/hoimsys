package hoimsys.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoimsys.dao.DepartmentMapper;
import hoimsys.po.Department;
import hoimsys.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	DepartmentMapper departementMapper;
	@Override
	public Department getByPrimaryKey(Integer dtId) {
		// TODO Auto-generated method stub
		return departementMapper.selectByPrimaryKey(dtId);
	}

}

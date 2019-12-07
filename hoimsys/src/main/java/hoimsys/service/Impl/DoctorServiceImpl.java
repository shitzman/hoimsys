package hoimsys.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hoimsys.dao.DoctorMapper;
import hoimsys.po.Doctor;
import hoimsys.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorMapper doctorMapper;
	@Override
	public Doctor getOneDoctorBydId(Integer dId) {
		// TODO Auto-generated method stub
		return doctorMapper.selectByPrimaryKey(dId);
	}
	
	@Transactional
	@Override
	public int updateDoctorBydId(Doctor doctor) {
		// TODO Auto-generated method stub
		
		
		int flag = doctorMapper.updateByPrimaryKeySelective(doctor);
		int err = 1/0;
		return flag;
	}

}

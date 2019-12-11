package hoimsys.service.Impl;

import java.util.ArrayList;
import java.util.List;

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
		return flag;
	}

	/*
	 * 根据部门id以及科室医生姓名查询
	 * 当dtId 与 dName 同时存在时，在此科室中查询所有姓名满足dName模糊匹配的科室医生；
	 * 只存在一个时，则按此条件查询所有科室医生
	 * 若无条件时，测返回所有科室医生
	 */
	@Override
	public List<Doctor> getListDoctorBydtIdAndLikedName(Integer dtId, String dName) {

		List<Doctor> doctorList = new ArrayList<Doctor>();
		if(dtId !=0 && dName != "") {
			List<Doctor> temDoctorList = doctorMapper.selectByLikeNameAndLimit1(dName);
			for(Doctor temD : temDoctorList) {
				if(temD.getDtId() == dtId) {
					doctorList.add(temD);
				}
			}
			
			return doctorList;
		}
		
		if(dName != "") {
			return doctorMapper.selectByLikeNameAndLimit1(dName);
		}
		if(dtId != 0) {
			return doctorMapper.selectBydtId(dtId);
		}
		
		return doctorMapper.selectAllDoctor();
	}

}

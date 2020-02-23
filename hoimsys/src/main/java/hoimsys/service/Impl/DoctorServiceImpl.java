package hoimsys.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hoimsys.bo.DtDoctor;
import hoimsys.dao.DoctorMapper;
import hoimsys.dao.RegistrationMapper;
import hoimsys.po.Doctor;
import hoimsys.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorMapper doctorMapper;
	@Autowired
	RegistrationMapper regMapper;
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
	public List<DtDoctor> getListDoctorBydtIdAndLikedName(Integer dtId, String dName) {

		List<DtDoctor> doctorList = new ArrayList<DtDoctor>();
		
		//条件都不为空
		if(dtId !=0 && dName != "") {
			List<DtDoctor> temDoctorList = doctorMapper.selectByLikeNameAndLimit1(dName);
			for(DtDoctor temD : temDoctorList) {
				if(temD.getDtId() == dtId) {
					doctorList.add(temD);
				}
			}
			//为查询到的所有医生统计其历史挂号单总预约量
			for(int i=0; i<doctorList.size(); i++) {
				doctorList.get(i).setRegNumbers(
						regMapper.selectNumbersBydId(doctorList.get(i).getdId())
						);
			}
			
			return doctorList;
		}
		//只按名称查询
		if(dName != "") {
			doctorList = doctorMapper.selectByLikeNameAndLimit1(dName);
			//为查询到的所有医生统计其历史挂号单总预约量
			for(int i=0; i<doctorList.size(); i++) {
				doctorList.get(i).setRegNumbers(
						regMapper.selectNumbersBydId(doctorList.get(i).getdId())
						);
			}
			return doctorList;
		}
		//只按部门查询
		if(dtId != 0) {
			doctorList = doctorMapper.selectBydtId(dtId);
			//为查询到的所有医生统计其历史挂号单总预约量
			for(int i=0; i<doctorList.size(); i++) {
				doctorList.get(i).setRegNumbers(
						regMapper.selectNumbersBydId(doctorList.get(i).getdId())
						);
			}
			return doctorList;
		}
		doctorList = doctorMapper.selectAllDoctor();
		//为查询到的所有医生统计其历史挂号单总预约量
		for(int i=0; i<doctorList.size(); i++) {
			doctorList.get(i).setRegNumbers(
					regMapper.selectNumbersBydId(doctorList.get(i).getdId())
					);
		}
		return doctorList;
	}

	@Override
	public DtDoctor getDtDoctorBydId(Integer dId) {
		// TODO Auto-generated method stub
		return doctorMapper.selectBydId(dId);
	}

	@Override
	public DtDoctor loginDtDoctor(String dMoile, String dPassword, Integer dLimitsNumber) {
		// TODO Auto-generated method stub
		return doctorMapper.selectDtDoctorByMobileAndPwdAndLimit(dMoile, dPassword, dLimitsNumber);
	}

	@Override
	public Doctor getDoctorBydMobile(String dMobile) {
		// TODO Auto-generated method stub
		return doctorMapper.selectDoctorBydMobile(dMobile);
	}

	/*
	 * 	医院方，医生注册
	 */
	@Override
	public Doctor saveDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		//doctor.setdLimitsNumber(0);//初始化权限为0，等待超级管理员为其重新分配身份
		
		if(doctorMapper.insertSelective(doctor)>0) {
			return doctorMapper.selectDoctorBydMobile(doctor.getdMobile());
		}
		
		return null;
	}

	@Override
	public List<DtDoctor> getRegDtdoctorList(String nameOrId) {
		// TODO Auto-generated method stub
		return doctorMapper.selectRegDtdoctorList(nameOrId);
	}

	@Override
	public List<DtDoctor> getAllDtdoctorList(String nameOrId) {
		// TODO Auto-generated method stub
		return doctorMapper.selectAllDtdoctorList(nameOrId);
	}

	@Override
	public List<DtDoctor> getDtdoctorList(String nameOrId) {
		// TODO Auto-generated method stub
		return doctorMapper.selectDtdoctorList(nameOrId);
	}

}

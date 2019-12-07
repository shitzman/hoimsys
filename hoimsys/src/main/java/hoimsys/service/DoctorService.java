package hoimsys.service;

import hoimsys.po.Doctor;

public interface DoctorService {

	/*
	 * 根据主键id获取医生信息
	 */
	Doctor getOneDoctorBydId(Integer dId);
	
	/*
	 * 测试事务
	 */
	int updateDoctorBydId(Doctor doctor);
}

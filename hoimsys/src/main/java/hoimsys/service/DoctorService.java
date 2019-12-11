package hoimsys.service;

import java.util.List;

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
	
	/*
	 * 根据部门id以及科室医生姓名查询
	 * 当dtId 与 dName 同时存在时，在此科室中查询所有姓名满足dName模糊匹配的科室医生；
	 * 只存在一个时，则按此条件查询所有科室医生
	 * 若无条件时，测返回所有科室医生
	 */
	List<Doctor> getListDoctorBydtIdAndLikedName(Integer dtId, String dName);

}

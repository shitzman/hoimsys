package hoimsys.service.Impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoimsys.dao.DoctorMapper;
import hoimsys.dao.PatientMapper;
import hoimsys.dao.RegistrationMapper;
import hoimsys.dao.TitleMapper;
import hoimsys.po.Doctor;
import hoimsys.po.Patient;
import hoimsys.po.Registration;
import hoimsys.po.Title;
import hoimsys.service.PatientService;
@Service
public class PatientServiceImpl implements PatientService {

	@Autowired
	PatientMapper patientMapper;
	@Autowired
	DoctorMapper doctorMapper;
	@Autowired
	TitleMapper titleMapper;
	@Autowired
	RegistrationMapper registrationMapper;
	
	@Override
	public Patient savePatient(Patient patient) {
		// TODO Auto-generated method stub
		patient.setpStatus(-1);
		patient.setpBirthday(new Date());
		int flag = patientMapper.insertSelective(patient);
		if(flag>0) {
			return patientMapper.selectByMobile(patient.getpMobile());
		}
		return null;
	}
	//根据病人用户手机号返回用户数据
	@Override
	public Patient getPatientByMobile(String Mobile) {
		return patientMapper.selectByMobile(Mobile);
	}
	//根据病人用户手机号以及密码获取用户信息
	@Override
	public Patient getPatientByMobielAndPassword(String pMobile, String pPassword) {
		// TODO Auto-generated method stub
		return patientMapper.selectByMobielAndPassword(pMobile, pPassword);
	}
	
	/*
	 * 病人用户挂号操作
	 * 接收数据:
	 * 	dateTime时间戳，预约时间，pId病人编号，dId医生编号
	 * 存入数据：
	 * 	dateTime,pId,dId,dtId挂号科室，rFee挂号费用，rStatus挂号状态(0)r_pay_number缴费凭证（0）未交费
	 * 
	 */
	@Override
	public Registration saveRegistartion(long dateTime, Integer pId, Integer dId) {
		// TODO Auto-generated method stub
		Registration registration = new Registration();
		
		//将时间戳转为date格式；10位
		//Timestamp rDate = new Timestamp(dateTime*1000);
		
		//将时间戳转为date格式；13位
		Timestamp rDate = new Timestamp(dateTime);
		
		Doctor doctor = doctorMapper.selectByPrimaryKey(dId);//获取医生信息，需要部门id;以及tid获取挂其号所需费用；
		Title title = titleMapper.selectByPrimaryKey(doctor.gettId());
		registration.setpId(pId);
		registration.setrDate(rDate);
		registration.setdId(dId);
		registration.setDtId(doctor.getDtId());
		registration.setrFee(BigDecimal.valueOf(title.gettFee()));
		//registration.setrStatus(0);//未缴费
		registration.setrStatus(1);//默认已缴费，跳过挂号单缴费模块……
		registration.setrPayNumber("0");
		
		int psId = (int)(pId+dateTime);
		registration.setPsId(psId);	//生成药单编号
		int flag = registrationMapper.insertSelective(registration);
		if(flag>0) {
			return registrationMapper.selectRegistrationBypIdAnddateTime(pId, rDate);
		}
		return null;
	}
	@Override
	public Patient updatePatient(Patient patient) {
		// TODO Auto-generated method stub
		int flag = patientMapper.updateByPrimaryKeySelective(patient);
		Patient newPatient = null;
		if(flag>0) {
			newPatient = patientMapper.selectByPrimaryKey(patient.getpId());
		}
		return newPatient;
	}
	
	
	@Override
	public List<Registration> getRegistrationsBypIdAndrStatus(Integer pId, Integer rStatus) {

		if(rStatus == -1) {
			return registrationMapper.selectRegistrationBypIdAtIng(pId);
		}
		
		return registrationMapper.selectRegistrationBypIdAndrStatus(pId, rStatus);
	}
	@Override
	public Patient getPatientBypId(Integer pId) {
		// TODO Auto-generated method stub
		return patientMapper.selectByPrimaryKey(pId);
	}

	
	
}

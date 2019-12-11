package hoimsys.service;

import java.util.List;

import hoimsys.po.Patient;
import hoimsys.po.Registration;

public interface PatientService {
	//将patient存入数据库，并将其从数据库中返回；
	Patient savePatient(Patient patient);
	
	//根据病人用户手机号获取病人信息；
	Patient getPatientByMobile(String Mobile);
	
	//根据病人用户手机号以及密码获取用户信息
	Patient getPatientByMobielAndPassword(String pMobile, String pPassword);
	
	//病人挂号操作
	Registration saveRegistartion(long dateTime, Integer pId, Integer dId);
	
	//修改病人信息,返回新病人信息对象(以病人id为标识）
	Patient updatePatient(Patient patient);
	
	//根据病人id以及挂号单所处状态查询挂号单
	List<Registration> getRegistrationsBypIdAndrStatus(Integer pId, Integer rStatus);

}

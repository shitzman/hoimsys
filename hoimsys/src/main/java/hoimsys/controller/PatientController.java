package hoimsys.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import hoimsys.bo.Msg;
import hoimsys.po.Doctor;
import hoimsys.po.Patient;
import hoimsys.po.Registration;
import hoimsys.service.PatientService;
import hoimsys.service.RegistrationService;

@Controller
@RequestMapping("api/patient")
@CrossOrigin
public class PatientController {

	@Autowired
	PatientService patientService;
	@Autowired
	RegistrationService regService;
	
	/*
	 * 病人用户注册
	 */
	@ResponseBody
	@PostMapping(value = "/reg", produces = "application/json;charset=UTF-8")
	public Msg patientRegister(@RequestBody Patient patient) {
		if(patientService.getPatientByMobile(patient.getpMobile())!=null) {
			return Msg.fail().resetMsg("用户手机号已被注册").add("patient", patient);
		}
		Patient newPatient = patientService.savePatient(patient);
		if(newPatient != null) {
			return Msg.success().add("patient", newPatient);
		}
		return Msg.fail();
	}
	
	/*
	 * 病人用户登录
	 */
	@ResponseBody
	@PostMapping("/login")
	public Msg patientLogin(String pMobile, String pPassword) {
		Patient patient  = patientService.getPatientByMobielAndPassword(pMobile, pPassword);
		if(patient != null) {
			return Msg.success().add("patient", patient).resetMsg("登录成功");
		}
		return Msg.fail().resetMsg("登录失败");
	}
	
	/*
	 * 病人挂号操作
	 */
	@ResponseBody
	@PostMapping("/appointment")
	public Msg patientAppointment(long dateTime, Integer pId, Integer dId) {
		
		//数据库的日期精度只能到10位；
		dateTime = (dateTime/1000)*1000;
		Timestamp rDate = new Timestamp(dateTime);
		Registration oldReg = regService.getRegistrationBypIdAnddateTime(pId, rDate);
		if(oldReg!=null) {
			return Msg.fail().resetMsg("请勿频繁操作").add("registration", oldReg);
		}
		
		Registration registration = patientService.saveRegistartion(dateTime, pId, dId);
		if(registration != null) {
			return Msg.success().add("registration", registration);
		}
		return Msg.fail().add("registration", registration);
	}
	/*
	 * 修改病人信息,返回新病人信息对象(以病人id为标识）
	 */
	@ResponseBody
	@PostMapping(value = "/editprofile", produces = "application/json;charset=UTF-8")
	public Msg editPatient(@RequestBody Patient patient) {
		
		Patient newPatient = patientService.updatePatient(patient);
		
		if(newPatient != null) {
			return Msg.success().resetMsg("修改信息成功").add("newPatient", newPatient);
		}
		
		return Msg.fail();
	}
	
	/*
	 * 根据病人id以及挂号单所处状态查询挂号单
	 * 默认-1查询所有处于进行中状态的挂号单
	 * (废弃）
	 */
	@ResponseBody
	@GetMapping("/order")
	public Msg patientOrder(
			Integer pId,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "rStatus", defaultValue = "-1") Integer rStatus) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<Registration> orderList = patientService.getRegistrationsBypIdAndrStatus(pId, rStatus);
		
		PageInfo<Registration> pageOrderList = new PageInfo<Registration>(orderList);
	
		return Msg.success().add("pageOrderList", pageOrderList);
	}
	
	
	
	
	
	
	
	
	
}

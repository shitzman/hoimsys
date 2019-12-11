package hoimsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	/*
	 * 病人用户注册
	 */
	@ResponseBody
	@PostMapping("/reg")
	public Msg patientRegister(Patient patient) {
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
			return Msg.success().add("patient", patient);
		}
		return Msg.fail().resetMsg("登录失败");
	}
	
	@ResponseBody
	@PostMapping("/appointment")
	public Msg patientAppointment(long dateTime, Integer pId, Integer dId) {
		
		Registration registration = patientService.saveRegistartion(dateTime, pId, dId);
		if(registration != null) {
			return Msg.success().add("registration", registration);
		}
		return Msg.fail().resetMsg("操作过于频繁请稍后再试");
	}
	
	@ResponseBody
	@PostMapping("/editprofile")
	public Msg editPatient(Patient patient) {
		
		Patient newPatient = patientService.updatePatient(patient);
		
		if(newPatient != null) {
			return Msg.success().resetMsg("修改信息成功").add("newPatient", newPatient);
		}
		
		return Msg.fail();
	}
	
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

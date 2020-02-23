package hoimsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import hoimsys.bo.DtDoctor;
import hoimsys.bo.Msg;
import hoimsys.bo.PrescriptionAndMedic;
import hoimsys.bo.PrescriptionInMedic;
import hoimsys.bo.RegistrationAndDtDoctor;
import hoimsys.po.Patient;
import hoimsys.po.Registration;
import hoimsys.service.DoctorService;
import hoimsys.service.PatientService;
import hoimsys.service.PrescriptionService;
import hoimsys.service.RegistrationService;

@RestController
@RequestMapping("api/order")
@CrossOrigin
public class RegistrationController {
	
	@Autowired
	RegistrationService regService;
	@Autowired
	PatientService patientService;
	@Autowired
	DoctorService doctorService;
	@Autowired
	PrescriptionService prescriptionService;
	
	/*
	 * 	根据病人id以及挂号单所处状态查询挂号单
	 * 	 根据病人id已经订单所处状态查询所有订单详情信息；
	 * 	在mapper层返回Registration对象；
	 *	service层将其封装到RegistrationAndDtDoctor对象中，此对象封装了Registration对象和DtDoctor对象；
	 * 	DtDoctor对象有封装了Doctor、Title、Department对象；
	 * 	改进：
	 * 		rStatus 为 0 或-1 （默认）是会查询状态码为 1-4，即进行中的挂号单
	 */
	@GetMapping("/getorders")
	public Msg getAllRegistrationBypIdAndrStatus(
			Integer pId,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "rStatus", defaultValue = "-1") Integer rStatus) {
		
		if(rStatus == 0) rStatus = -1; //跳过未付费，直接查询进行中的状态，在存储挂号单service中已将rStatus默认0（未付费状态）改为1，所以现在没有0状态
		
		PageHelper.startPage(pageNum, pageSize);
		List<RegistrationAndDtDoctor> RegDtList = regService.getRegistrationsBypIdAndrStatus(pId, rStatus);
		
		PageInfo<RegistrationAndDtDoctor> pageOrderList = new PageInfo<RegistrationAndDtDoctor>(RegDtList);
		
		return Msg.success().add("pageOrderList", pageOrderList);
	}
	
	
	/*
	 * 	根据订单id查看挂号单详情
	 * 	获取挂号单信息以及以下相关信息：
	 * 	病人信息 Patient
	 * 	医生信息（详情）DtDoctor
	 * 	药单信息 Prescription,封装药品信息
	 */
	@GetMapping("/getorder")
	public Msg getRegistrationBrId(Integer rId) {
		
		Registration registration = regService.getRegistrationByrId(rId);//挂号单信息
		if(registration != null) {
			Patient patient = patientService.getPatientBypId(registration.getpId());//获取相关病人信息
			DtDoctor dtDoctor = doctorService.getDtDoctorBydId(registration.getdId());//获取相关医生详情信息
			
			//List<PrescriptionInMedic> prescriptionList = prescriptionService.getAllPrescriptionBypsId(registration.getPsId());//获取药品信息
			List<PrescriptionAndMedic> pAndmList = prescriptionService.getAllPrescriptionAndMedicBypsId(registration.getPsId());
			
			return Msg.success()
					.add("registration", registration)
					.add("patient", patient)
					.add("dtDoctor", dtDoctor)
					.add("pAndmList", pAndmList);
		}
		return Msg.fail().add("registration", registration);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

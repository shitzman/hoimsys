package hoimsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import hoimsys.bo.DayNumbers;
import hoimsys.bo.DoctorRegAndPat;
import hoimsys.bo.DoctorUpdateReg;
import hoimsys.bo.DtDoctor;
import hoimsys.bo.MedDetails;
import hoimsys.bo.Msg;
import hoimsys.po.Department;
import hoimsys.po.Doctor;
import hoimsys.po.Registration;
import hoimsys.po.Title;
import hoimsys.service.DepartmentService;
import hoimsys.service.DoctorService;
import hoimsys.service.PrescriptionService;
import hoimsys.service.RegistrationService;
import hoimsys.service.TitleService;
import hoimsys.util.DateUtil;

@RestController
@RequestMapping("api/doctor")
@CrossOrigin
public class DoctorController {

	@Autowired
	DoctorService doctorService;
	@Autowired
	TitleService titleService;
	@Autowired
	DateUtil dateUtil;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	RegistrationService regService;
	@Autowired
	PrescriptionService preService;
	
	/*
	 * 	医院方：
	 * 	推荐医生操作，即，修改挂号单中的医生id字段
	 * 	接受参数，挂号单id以及所推荐医生id
	 * 
	 */
	@PostMapping("/recomdoctor")
	Msg doctorRecom(Integer rId, Integer dId) {
		
		Registration reg = new Registration();
		reg.setrId(rId);
		reg.setdId(dId);	//在这应该查询出医生所属科室，连并科室id一块修改
		
		if(regService.changeRegByRegId(reg)>0) {
			return Msg.success().resetMsg("推荐成功");
		}
		
		return Msg.fail().resetMsg("推荐失败");
	}
	
	/*
	 * 	医院方：
	 * 	超级管理员，批准医生申请
	 * 	接受参数 医生id(dId)
	 * 
	 */
	@PostMapping("/superadmin/ratifyregdoctor")
	Msg superAdminRatifyRegDoc(Integer dId) {
		if(dId!=null && dId>0) {
			Doctor doctor = doctorService.getOneDoctorBydId(dId);
			doctor.setdLimitsNumber(Math.abs(doctor.getdLimitsNumber()));//将权限编号设为正值；即为可用；
			
			if(doctorService.updateDoctorBydId(doctor)>0)
				return Msg.success().add("doctor", doctor);
		}
		
		return Msg.fail();
	}
	
	
	/*
	 * 	医院方：
	 * 	超级管理员查看所有医生申请记录
	 */
	@GetMapping("/superadmin/showregdoc")
	Msg superAdminShowDtdocReg(
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<DtDoctor> regDtDoctor = doctorService.getRegDtdoctorList(search);
		PageInfo<DtDoctor> pageRegDtDoctor = new PageInfo<DtDoctor>(regDtDoctor);
		return Msg.success().add("pageRegDtDoctor", pageRegDtDoctor);
	}
	
	
	/*
	 * 	医院方
	 * 	药品管理员将挂号单状态改为5（取药完毕动作）
	 * 	接受参数，挂号单id（regId)
	 */
	@PostMapping("/medadmin/finish")
	Msg MedAdminChangeRegStatus(Integer regId) {
		if(regService.changerStatusByregId(regId, 5)>0) {
			return Msg.success().resetMsg("取药成功");
		}
		return Msg.fail();
	}
	
	
	
	/*
	 * 	医院方
	 * 	药品管理员获取所有挂号单状态为3的挂号单列表（此时状态为待取药）
	 * 	[将状态码修改为可变的，接受参数，默认为3，即待取药]
	 */
	@GetMapping("/medadmin/getreg")
	Msg MedAdminShowReg(
			@RequestParam(value = "rStatus", defaultValue = "3") Integer rStatus,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<DoctorRegAndPat> drp = regService.getAllDoctorRegAndPatBydIdAndrStatus(rStatus,search);//3状态为挂号单已处理单为取药的状态
		PageInfo<DoctorRegAndPat> pageDrpList = new PageInfo<DoctorRegAndPat>(drp);
		
		return Msg.success().add("pageDrpList", pageDrpList);
	}
	
	/*
	 * 	药品管理员，获取 待处理  或  已处理   的挂号单（待取药列表）信息列表后，
	 * 	根据药单编号，获取该药单所有药品详情
	 */
	@GetMapping("/getmeds")
	Msg MedicineAdminShowMeds(Integer psId,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<MedDetails> medsList = preService.getMedsBypsId(psId);
		
		PageInfo<MedDetails> pageMeds = new PageInfo<MedDetails>(medsList);
		
		return Msg.success().add("pageMeds", pageMeds);
	}
	/*
	 *	 医院方，医生修改挂号单信息 接收json格式：
	 *  { 
	 *  	"rId":"37",	//挂号单id
	 *  	"rInfo":"标题",
	 * 		"rRemarks":"详情", 
	 * 		"pres":{ 	//药品map，key为药品id，value为药品数量；若key重复则数量相加
	 * 			"1":"1", 
	 * 			"2":"2" 
	 * 		}
	 * 	}
	 * 
	 */
	@PostMapping(value = "/updatereg", produces = "application/json;charset=UTF-8")
	Msg DoctorUpdateReg(@RequestBody DoctorUpdateReg docUpReg) {
		System.out.println(docUpReg);
		
		Registration reg = new Registration();
		reg.setrId(docUpReg.getrId());
		reg.setrInfo(docUpReg.getrInfo());
		reg.setrRemark(docUpReg.getrRemarks());
		reg.setrStatus(3); 	//修改挂号单状态为 3 （已诊断）
		//若修改成功则返回此挂号单的药单编号，否则返回-1；
		Integer psId = regService.UpdageRegInfoAndRemark(reg);
		if(psId == -1) {
			return Msg.fail();
		}
		
		//存储所开药品
		if(docUpReg.getPres()!=null)	//修复不开药无法提交问题
			preService.savePrescriptionByMaps(psId, docUpReg.getPres());
		
		
		
		return Msg.success();
	}
	
	
	/*
	 * 	医院方，医生登录后查看   待处理  或  已处理   的挂号单信息列表
	 * 	参数：
	 * 		Integer dId 医生id
	 * 		Integer rStatus 挂号单状态，1为待处理，3为已处理；（2为待科室医生处理，已遗弃此状态）
	 * 		
	 * 
	 */
	@GetMapping(value = "/showdrp")
	Msg showDoctorRegAndPats(
			Integer dId,
			Integer rStatus,
			@RequestParam(value = "search", defaultValue = "") String search,
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<DoctorRegAndPat> drp = regService.getDoctorRegAndPatBydIdAndrStatus(dId, rStatus, search);//1状态为待诊断状态
		PageInfo<DoctorRegAndPat> pageDrpList = new PageInfo<DoctorRegAndPat>(drp);
		
		return Msg.success().add("pageDrpList", pageDrpList);
	}
	
	
	/*
	 * 	医院方注册接口：
	 * 	所需参数：Doctor(dLimitsNumber为期待职位编号）
	 * 	注册填写申请信息，超级管理员分配身份后方可使用
	 * 	不允许注册手机号重复
	 */
	@PostMapping(value = "/reg", produces = "application/json;charset=UTF-8")
	Msg doctorReg(@RequestBody Doctor doctor) {
		
		if(doctorService.getDoctorBydMobile(doctor.getdMobile())!=null) {
			return Msg.fail().resetMsg("手机号已被注册").add("doctor", doctor);
		}
		//将期待职位编号改为负值，管理员审核可用；
		if(doctor.getdLimitsNumber()>0) {
			doctor.setdLimitsNumber(-doctor.getdLimitsNumber());
		}
		Doctor newDoctor = doctorService.saveDoctor(doctor);
		if(newDoctor != null) {
			return Msg.success().add("newDoctor", newDoctor).resetMsg("注册成功");
		}
		return Msg.fail().resetMsg("注册失败");
	}
	
	/*
	 * 	医院方登录接口：
	 * 	所需参数： dMoile(手机号）,dPassword（密码）,dLimitsNumber（权限号）
	 * 
	 * dLimitsNumber（权限号）详解：
	 * 		科室医生：dLimitsNumber=1
	 * 		门诊医生：dLimitsNumber=2
	 * 		药房管理员：dLimitsNumber=3
	 * 		超级管理员：dLimitsNumber=99
	 * 		注册时dLimitsNumber=0需超级管理员给予账号身份
	 * 	
	 */
	@GetMapping("/login")
	Msg doctorLogin(String dMobile, String dPassword, Integer dLimitsNumber) {
		DtDoctor dtDoctor = doctorService.loginDtDoctor(dMobile, dPassword, dLimitsNumber);
		
		if(dtDoctor != null) {
			return Msg.success().add("dtDoctor", dtDoctor).resetMsg("登录成功");
		}
		return Msg.fail().resetMsg("登录失败");
	}

	/*
	 * 根据医生ID返回医生信息
	 */
	@GetMapping("/getdoctor")
	Msg doctorBydId(Integer dId) {
		Doctor doctor = doctorService.getOneDoctorBydId(dId);
		Title title = titleService.getTitleBytId(doctor.gettId());
		List<DayNumbers> dayNumbersList = dateUtil.getDaysRegistrationCount(dId, 4);
		Department department = departmentService.getByPrimaryKey(doctor.getDtId());
		if (doctor == null) {
			return Msg.fail();
		}
		return Msg.success().add("doctor", doctor).add("title", title).add("dayNumList", dayNumbersList).add("department", department);
	}
	
	/*
	 * 根据条件返回部门医生列表
	 */
	@GetMapping("/getdoctors")
	Msg listDoctorBydtIdAndLikedName(
			@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum,
			@RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
			@RequestParam(value = "dtId", defaultValue = "0") Integer dtId,
			@RequestParam(value = "dName", defaultValue = "") String dName) {
		
		PageHelper.startPage(pageNum, pageSize);
		List<DtDoctor> doctorList = doctorService.getListDoctorBydtIdAndLikedName(dtId,dName);
		
		PageInfo<DtDoctor> pageDoctorList = new PageInfo<DtDoctor>(doctorList);
		
		return Msg.success().add("pageDoctorList", pageDoctorList);
	}

}

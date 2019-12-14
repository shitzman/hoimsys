package hoimsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import hoimsys.bo.DayNumbers;
import hoimsys.bo.DtDoctor;
import hoimsys.bo.Msg;
import hoimsys.po.Department;
import hoimsys.po.Doctor;
import hoimsys.po.Title;
import hoimsys.service.DepartmentService;
import hoimsys.service.DoctorService;
import hoimsys.service.TitleService;
import hoimsys.util.DateUtil;

@Controller
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

	/*
	 * 根据医生ID返回医生信息
	 */
	@ResponseBody
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
	@ResponseBody
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

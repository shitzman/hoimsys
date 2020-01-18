package hoimsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hoimsys.bo.Msg;
import hoimsys.po.Prescription;
import hoimsys.service.PrescriptionService;

@RestController
@RequestMapping("api/prescription")
@CrossOrigin
public class PrescriptionController {

	@Autowired
	PrescriptionService preService;
	
	/*
	 * 	开药接口
	 * 	部门医生，门诊医生均可调用
	 * 	至少包含：
	 * 	药单编号、药品ID、数量、
	 */
	@PostMapping("/savepre")
	Msg savePrescription(Prescription pre) {
		
		if(preService.savePrescription(pre)>0) {
			Msg.success().resetMsg("添加药品成功");
		}
		
		return Msg.fail();
	}
	
	
}


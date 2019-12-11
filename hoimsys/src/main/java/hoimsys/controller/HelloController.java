package hoimsys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hoimsys.po.Doctor;
import hoimsys.service.DoctorService;

@Controller
@CrossOrigin
public class HelloController {
	
	@Autowired
	DoctorService doctorService;
	
	@ResponseBody
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public Doctor hello() {
		return doctorService.getOneDoctorBydId(2);
	}

}

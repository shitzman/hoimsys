package hoimsys.service;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import hoimsys.HoimsysApplication;
import hoimsys.po.Doctor;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {HoimsysApplication.class})
public class DoctorTest {
	
	@Autowired
	DoctorService doctorService;
	
	@Test
	public void updataDoctorTest() {
		Doctor d1 = new Doctor();
		d1.setdId(1);
		d1.setdPassword("12345");
		System.out.println(doctorService.updateDoctorBydId(d1));
	}

}

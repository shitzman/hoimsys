package hoimsys.dao;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import hoimsys.bo.PrescriptionAndMedic;
import hoimsys.bo.PrescriptionInMedic;
import hoimsys.service.PrescriptionService;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class PrescriptionMapperTest {
	
	@Autowired
	PrescriptionMapper preMapper;
	@Autowired
	PrescriptionService preService;
	
	/*
	 * 	废弃
	 */
	@Test
	public void selectPrescriptionBypsIdTest() {
		List<PrescriptionInMedic> prescriptionList = preMapper.selectPrescriptionBypsId(1);
		for(PrescriptionInMedic pre : prescriptionList) {
			System.out.println(pre);
		}
	}
	
	@Test
	public void selectAllPrescriptionBypsId() {
		/*
		 * List<Prescription> prescriptionList =
		 * preMapper.selectAllPrescriptionBypsId(1); for(Prescription pre :
		 * prescriptionList) { System.out.println(pre); }
		 */
		
		List<PrescriptionAndMedic> pAndmList = preService.getAllPrescriptionAndMedicBypsId(1);
		for(PrescriptionAndMedic pm : pAndmList) {
			System.out.println(pm);
		}
	}


}

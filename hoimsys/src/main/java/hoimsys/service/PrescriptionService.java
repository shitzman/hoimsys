package hoimsys.service;

import java.util.List;

import hoimsys.bo.PrescriptionAndMedic;
import hoimsys.bo.PrescriptionInMedic;

public interface PrescriptionService {
	
	//根据药单id查询所有药品（废弃）
	List<PrescriptionInMedic> getAllPrescriptionBypsId(Integer psId);
	
	//根据药单id查询所有药品（废弃）
	List<PrescriptionAndMedic> getAllPrescriptionAndMedicBypsId(Integer psId);

}

package hoimsys.service;

import java.util.List;
import java.util.Map;

import hoimsys.bo.MedDetails;
import hoimsys.bo.PrescriptionAndMedic;
import hoimsys.bo.PrescriptionInMedic;
import hoimsys.po.Prescription;

public interface PrescriptionService {
	
	//根据药单id查询所有药品（废弃）
	List<PrescriptionInMedic> getAllPrescriptionBypsId(Integer psId);
	
	//根据药单id查询所有药品
	List<PrescriptionAndMedic> getAllPrescriptionAndMedicBypsId(Integer psId);
	
	//添加药品
	int savePrescription(Prescription pre);
	
	//批量添加药品
	int savePrescriptionByMaps(Integer psId, Map<Integer,Integer> pres);
	
	//根据药单id查询所有药品详情
    List<MedDetails> getMedsBypsId(Integer psId);
	
	

}

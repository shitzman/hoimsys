package hoimsys.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoimsys.bo.PrescriptionAndMedic;
import hoimsys.bo.PrescriptionInMedic;
import hoimsys.dao.MedicineMapper;
import hoimsys.dao.PrescriptionMapper;
import hoimsys.po.Prescription;
import hoimsys.service.PrescriptionService;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {

	@Autowired
	PrescriptionMapper prescriptionMapper;
	@Autowired
	MedicineMapper medicineMapper;
	
	@Override
	/*
	 * 	废弃
	 */
	public List<PrescriptionInMedic> getAllPrescriptionBypsId(Integer psId) {
		// TODO Auto-generated method stub
		return prescriptionMapper.selectPrescriptionBypsId(psId);
	}
	
	
	@Override
	public List<PrescriptionAndMedic> getAllPrescriptionAndMedicBypsId(Integer psId) {
		// TODO Auto-generated method stub
		
		List<Prescription> prescriptionList = prescriptionMapper.selectAllPrescriptionBypsId(psId);
		
		List<PrescriptionAndMedic> PAndMList = new ArrayList<PrescriptionAndMedic>();
		
		for(Prescription p : prescriptionList) {
			PAndMList.add(
					new PrescriptionAndMedic(p,medicineMapper.selectByPrimaryKey(p.getmId()))
					);
		}
		
		return PAndMList;
	}

}

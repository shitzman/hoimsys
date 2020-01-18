package hoimsys.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoimsys.bo.PrescriptionAndMedic;
import hoimsys.bo.PrescriptionInMedic;
import hoimsys.dao.MedicineMapper;
import hoimsys.dao.PrescriptionMapper;
import hoimsys.po.Medicine;
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


	@Override
	public int savePrescription(Prescription pre) {
		// TODO Auto-generated method stub
		return prescriptionMapper.insertSelective(pre);
	}


	@Override
	public int savePrescriptionByMaps(Integer psId, Map<Integer, Integer> pres) {
		// TODO Auto-generated method stub
		/*
		 * map中,key为药品id，value为药品数量
		 */
		for(Integer key : pres.keySet()) {
			
			Medicine m = medicineMapper.selectByPrimaryKey(key);//根据药品id获取药品详情信息；
			
			Prescription p = new Prescription();	//构造药单表所需信息；
			p.setPsId(psId);	//药单id
			p.setmId(key);	//药品id
			p.setPsNumber(pres.get(key));//药品数量
			if(m!=null)	//防止药品id出错找不到药品
				p.setPsPrice(m.getmPrice());	//药品单价
			
			Prescription oldP =  prescriptionMapper.getPrescriptionByrIdAndpsId(key, psId);  //如果该记录已存在，则在该记录上将数量更新
			if(oldP != null) {
				p.setPsNumber(p.getPsNumber()+oldP.getPsNumber());
				prescriptionMapper.updateByPrimaryKeyAndmIdSelective(p);
			}else {
				prescriptionMapper.insertSelective(p);
			}
			
		}
		
		return 0;
	}

}

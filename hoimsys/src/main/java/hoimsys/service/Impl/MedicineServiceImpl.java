package hoimsys.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoimsys.dao.MedicineMapper;
import hoimsys.po.Medicine;
import hoimsys.service.MedicineService;
@Service
public class MedicineServiceImpl implements MedicineService {

	@Autowired
	MedicineMapper medMapper;
	
	@Override
	public List<Medicine> getMedicineList() {
		// TODO Auto-generated method stub
		return medMapper.selectListMedicine();
	}

}

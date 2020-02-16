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
	public List<Medicine> getMedicineList(String nameOrId) {
		// TODO Auto-generated method stub
		return medMapper.selectListMedicine(nameOrId);
	}

	@Override
	public int addOneMedicine(Medicine med) {
		// TODO Auto-generated method stub
		return medMapper.insertSelective(med);
	}

	@Override
	public int updateOneMedicine(Medicine med) {
		// TODO Auto-generated method stub
		return medMapper.updateByPrimaryKeySelective(med);
	}

	@Override
	public int delOneMedicine(Integer mId) {
		// TODO Auto-generated method stub
		return medMapper.deleteByPrimaryKey(mId);
	}

	@Override
	public Medicine getMedicineBymId(Integer mId) {
		// TODO Auto-generated method stub
		return medMapper.selectByPrimaryKey(mId);
	}

}

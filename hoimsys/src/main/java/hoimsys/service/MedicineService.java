package hoimsys.service;

import java.util.List;

import hoimsys.po.Medicine;

public interface MedicineService {

	List<Medicine> getMedicineList(String nameOrId);
	
	int addOneMedicine(Medicine med);
	
	int updateOneMedicine(Medicine med);
	
	int delOneMedicine(Integer mId);
	
	Medicine getMedicineBymId(Integer mId);
}

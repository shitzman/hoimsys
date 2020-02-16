package hoimsys.service;

import java.util.List;

import hoimsys.po.Medicine;

public interface MedicineService {

	List<Medicine> getMedicineList(String nameOrId);
}

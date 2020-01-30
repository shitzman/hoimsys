package hoimsys.dao;

import java.util.List;

import hoimsys.po.Medicine;

public interface MedicineMapper {
    int deleteByPrimaryKey(Integer mId);

    int insert(Medicine record);

    int insertSelective(Medicine record);

    Medicine selectByPrimaryKey(Integer mId);

    int updateByPrimaryKeySelective(Medicine record);

    int updateByPrimaryKey(Medicine record);
    
    List<Medicine> selectListMedicine();
    
    
}
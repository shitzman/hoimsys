package hoimsys.dao;

import hoimsys.po.Prescription;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(Integer psId);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    Prescription selectByPrimaryKey(Integer psId);

    int updateByPrimaryKeySelective(Prescription record);

    int updateByPrimaryKey(Prescription record);
}
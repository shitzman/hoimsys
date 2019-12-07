package hoimsys.dao;

import hoimsys.po.Patient;

public interface PatientMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
}
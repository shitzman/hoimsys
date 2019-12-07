package hoimsys.dao;

import hoimsys.po.Registration;

public interface RegistrationMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Registration record);

    int insertSelective(Registration record);

    Registration selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Registration record);

    int updateByPrimaryKey(Registration record);
}
package hoimsys.dao;

import org.apache.ibatis.annotations.Param;

import hoimsys.po.Patient;

public interface PatientMapper {
    int deleteByPrimaryKey(Integer pId);

    int insert(Patient record);

    int insertSelective(Patient record);

    Patient selectByPrimaryKey(Integer pId);

    int updateByPrimaryKeySelective(Patient record);

    int updateByPrimaryKey(Patient record);
    
    //根据手机号查询该病人用户信息
    Patient selectByMobile(String pMobile);
    //根据手机号以及密码查询病人用户信息；
    Patient selectByMobielAndPassword(@Param("pMobile")String pMobile, @Param("pPassword")String pPassword);
}
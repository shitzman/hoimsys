package hoimsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hoimsys.po.Doctor;

public interface DoctorMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);
    
    //根据科室id查询医生
    List<Doctor> selectBydtId(Integer dtId);
    
    //根据姓名模糊查询科室医生
    List<Doctor> selectByLikeNameAndLimit1(@Param("dName")String dName);
    
    //获取全部科室医生信息
    List<Doctor> selectAllDoctor();
    
    
    
}
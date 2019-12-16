package hoimsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hoimsys.bo.DtDoctor;
import hoimsys.po.Doctor;

public interface DoctorMapper {
    int deleteByPrimaryKey(Integer dId);

    int insert(Doctor record);

    int insertSelective(Doctor record);

    Doctor selectByPrimaryKey(Integer dId);

    int updateByPrimaryKeySelective(Doctor record);

    int updateByPrimaryKey(Doctor record);
    
    //根据科室id查询医生
    List<DtDoctor> selectBydtId(Integer dtId);
    
    //根据姓名模糊查询科室医生
    List<DtDoctor> selectByLikeNameAndLimit1(@Param("dName")String dName);
    
    //获取全部科室医生信息
    List<DtDoctor> selectAllDoctor();
    
    //根据医生id查询医生详情信息
    DtDoctor selectBydId(Integer dId);
    
}
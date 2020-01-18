package hoimsys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import hoimsys.bo.PrescriptionInMedic;
import hoimsys.po.Prescription;

public interface PrescriptionMapper {
    int deleteByPrimaryKey(Integer psId);

    int insert(Prescription record);

    int insertSelective(Prescription record);

    Prescription selectByPrimaryKey(Integer psId);

    int updateByPrimaryKeySelective(Prescription record);
    int updateByPrimaryKeyAndmIdSelective(Prescription record);

    int updateByPrimaryKey(Prescription record);
    
    //根据药单id查询所有药物详情，药单表为药单id与药品id联合主键（废弃）
    List<PrescriptionInMedic> selectPrescriptionBypsId(Integer psId);
    
    //根据药单id查询所有药品
    List<Prescription> selectAllPrescriptionBypsId(Integer psId);
    
    //根据药单id以及药品id查询记录
    Prescription getPrescriptionByrIdAndpsId(@Param("mId")Integer mId, @Param("psId")Integer psId);
}
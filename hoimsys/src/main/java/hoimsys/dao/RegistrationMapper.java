package hoimsys.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import hoimsys.po.Registration;

public interface RegistrationMapper {
    int deleteByPrimaryKey(Integer rId);

    int insert(Registration record);

    int insertSelective(Registration record);

    Registration selectByPrimaryKey(Integer rId);

    int updateByPrimaryKeySelective(Registration record);

    int updateByPrimaryKey(Registration record);
    
    //根据病人id与预约时间查询挂号单
    Registration selectRegistrationBypIdAnddateTime(@Param("pId")Integer pId, @Param("dateTime")Date dateTime);
    
    //根据病人id以及挂号单所处状态查询挂号单
    List<Registration> selectRegistrationBypIdAndrStatus(@Param("pId")Integer pId, @Param("rStatus") Integer rStatus);
    
    //根据病人id查询所有处于进行中的挂号单(1-5)之间的状态
    List<Registration> selectRegistrationBypIdAtIng(@Param("pId")Integer pId);
    
    //根据日期以及医生id查询当天的挂号单数量
    int selectNumbersByDateAnddId(@Param("rDate")String rDate, @Param("tId")Integer dId);
    
    //根据医生id返回挂号单数量
    int selectNumbersBydId(@Param("tId")Integer dId);
    
}
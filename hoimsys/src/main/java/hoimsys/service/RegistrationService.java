package hoimsys.service;

import java.util.Date;

import org.apache.ibatis.annotations.Param;

import hoimsys.po.Registration;

public interface RegistrationService {
	
	//根据日期以及医生id查询当天的挂号单数量
    int getNumbersByDateAnddId(@Param("rDate")String rDate, @Param("tId")Integer tId);
    
    //根据病人id与预约时间查询挂号单
    Registration getRegistrationBypIdAnddateTime(@Param("pId")Integer pId, @Param("dateTime")Date dateTime);

}

package hoimsys.service.Impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoimsys.bo.RegistrationAndDtDoctor;
import hoimsys.dao.DoctorMapper;
import hoimsys.dao.RegistrationMapper;
import hoimsys.po.Registration;
import hoimsys.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationMapper regMapper;
	@Autowired
	DoctorMapper doctorMapper;
	
	@Override
	public int getNumbersByDateAnddId(String rDate, Integer tId) {
		// TODO Auto-generated method stub
		return regMapper.selectNumbersByDateAnddId(rDate, tId);
	}
	@Override
	public Registration getRegistrationBypIdAnddateTime(Integer pId, Date dateTime) {
		// TODO Auto-generated method stub
		return regMapper.selectRegistrationBypIdAnddateTime(pId, dateTime);
	}
	@Override
	
	/*
	 * 	根据病人id已经订单所处状态查询所有订单详情信息；
	 * 	在mapper层返回Registration对象；
	 *	 在这里将其封装到RegistrationAndDtDoctor对象中，此对象封装了Registration对象和DtDoctor对象；
	 * 	DtDoctor对象有封装了Doctor、Title、Department对象；
	 */
	public List<RegistrationAndDtDoctor> getRegistrationsBypIdAndrStatus(Integer pId, Integer rStatus) {
		// TODO Auto-generated method stub
		List<Registration> regList = new ArrayList<Registration>();
		if(rStatus == -1) {
			regList =  regMapper.selectRegistrationBypIdAtIng(pId);
		}else {
			regList =regMapper.selectRegistrationBypIdAndrStatus(pId, rStatus);
		}
		
		List<RegistrationAndDtDoctor> regDtList = new ArrayList<RegistrationAndDtDoctor>();
		
		for(Registration reg : regList) {
			regDtList.add(
					new RegistrationAndDtDoctor(reg,doctorMapper.selectBydId(reg.getdId()))
					);
		}
		
		
		return regDtList;
	}
	@Override
	public Registration getRegistrationByrId(Integer rId) {
		// TODO Auto-generated method stub
		return regMapper.selectByPrimaryKey(rId);
	}

}

package hoimsys.service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoimsys.dao.RegistrationMapper;
import hoimsys.po.Registration;
import hoimsys.service.RegistrationService;

@Service
public class RegistrationServiceImpl implements RegistrationService {

	@Autowired
	RegistrationMapper regMapper;
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

}

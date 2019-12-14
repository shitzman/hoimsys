package hoimsys.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hoimsys.dao.TitleMapper;
import hoimsys.po.Title;
import hoimsys.service.TitleService;
@Service
public class TitleServiceImp implements TitleService {

	@Autowired
	TitleMapper titleMapper;
	
	@Override
	public Title getTitleBytId(Integer tId) {
		// TODO Auto-generated method stub
		return titleMapper.selectByPrimaryKey(tId);
	}

}

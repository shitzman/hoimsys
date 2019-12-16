package hoimsys.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import hoimsys.po.Registration;
import hoimsys.util.DateUtil;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
public class RegistrationMapperTest {
	
	@Autowired
	RegistrationMapper regMapper;
	@Autowired
	DateUtil dateUtil;
	
	@Test
	void selectRegistrationBypIdAnddateTimeTest() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = null;
		try {
			date1 = sdf.parse("2019-12-03 00:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Registration re = regMapper.selectRegistrationBypIdAnddateTime(2, date1);
		System.out.println(re);
	}
	
	@Test
	void dateTest() {
		System.out.println(dateUtil.getDaysRegistrationCount(1,4));
		//System.out.println(regMapper.selectNumbersByDateAnddId("2019-12-03", 7));
	}
	



}

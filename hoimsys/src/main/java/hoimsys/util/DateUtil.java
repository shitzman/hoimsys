package hoimsys.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hoimsys.bo.DayNumbers;
import hoimsys.dao.RegistrationMapper;
@Component
public class DateUtil {
	@Autowired
	RegistrationMapper regMapper;

	public List<DayNumbers>getDaysRegistrationCount(Integer dId, Integer days) {
		
		List<DayNumbers> dayNumbersList = new ArrayList<DayNumbers>();
		
		Date date=new Date();//取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		for(int i=0; i<days; i++) {
			calendar.add(calendar.DATE,1);//把日期往后增加1天.整数往后推,负数往前移动
			date=calendar.getTime(); //这个时间就是日期往后推1天的结果 
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			int num = regMapper.selectNumbersByDateAnddId(formatter.format(date), dId);
			dayNumbersList.add(new DayNumbers(date.getTime(),num));
		}
		//calendar.add(calendar.DATE,1);//把日期往后增加一天.整数往后推,负数往前移动
		//String dateString = formatter.format(date);
		//System.out.println(dateString);
		
		return dayNumbersList;
	}
}

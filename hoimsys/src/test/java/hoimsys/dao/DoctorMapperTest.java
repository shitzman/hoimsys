package hoimsys.dao;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.ResourceUtils;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@SpringBootTest
class DoctorMapperTest {
	@Autowired
	DoctorMapper doctorMapper;


	/*
	 * @Test void selectBydtIdTest() {
	 * System.out.println(doctorMapper.selectBydtId(2)); }
	 */
	@Test
	void selectByLikeNameAndLimit1Test() {
		System.out.println(doctorMapper.selectByLikeNameAndLimit1("李"));
	}
	
	
	
	@Test
	void tempTest() throws FileNotFoundException {

		/*
		 * long time1 = 1575789855; Date date1 = new Date(time1*1000);
		 * System.out.println(date1); System.out.println(new Timestamp(time1*1000));
		 */
		
		String path = ResourceUtils.getURL("classpath:").getPath();
		System.out.println(path);
	}

	@Test
	void selectDtDoctByDId() {
		System.out.println(doctorMapper.selectBydId(1));
	}

}

package hoimsys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("hoimsys.dao")
public class HoimsysApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoimsysApplication.class, args);
	}

}

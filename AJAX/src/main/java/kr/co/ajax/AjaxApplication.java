package kr.co.ajax;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("kr.co.ajax.dao")
@SpringBootApplication
public class AjaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(AjaxApplication.class, args);
	}

}

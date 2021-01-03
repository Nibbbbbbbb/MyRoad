package cn.noobbb.myroad;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("cn.noobbb.myroad.repository")
@SpringBootApplication
public class MyroadSysApplication {

	public static void main(String[] args) {

		SpringApplication.run(MyroadSysApplication.class, args);
		System.out.println("系统启动成功\n");

	}

}

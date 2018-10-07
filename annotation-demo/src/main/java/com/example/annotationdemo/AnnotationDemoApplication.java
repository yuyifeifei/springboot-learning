package com.example.annotationdemo;

import com.example.annotationdemo.annotation.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@EnableAspectJAutoProxy//开启aop
public class AnnotationDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnotationDemoApplication.class, args);
	}


	@RequestMapping("/")
	@Test("测试")
	public List<String> getById(String id) {
//      haha();
		System.err.println("o+++++++++++++++++");
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("qwe");
		list.add("asd");
		return list;
	}
}
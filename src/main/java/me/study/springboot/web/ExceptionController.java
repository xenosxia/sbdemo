package me.study.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import me.study.springboot.exception.MyException;

@Controller
public class ExceptionController {

	@RequestMapping("/throw-global-exception")
	public String hello() throws Exception {
		throw new Exception("发生全局错误");
	}

	@RequestMapping("/throw-json-exception")
	public String json() throws MyException {
		throw new MyException("发生json错误");
	}

}
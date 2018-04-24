package com.c5game.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;
import eu.bitwalker.useragentutils.Version;

@Controller
public class MainPageController {

	@RequestMapping("/dota2.do")
	public String dota2(HttpServletRequest request,HttpServletResponse response) {
		//获取浏览器信息
		Browser browser = UserAgent.parseUserAgentString(request.getHeader("User-Agent")).getBrowser();
		//获取浏览器版本号
		Version version = browser.getVersion(request.getHeader("User-Agent"));
		String info = browser.getName() + "/" + version.getVersion();
		System.out.println(info);
		
		return "dota2";
	}
	
	@RequestMapping("/getNumber.do")
	public void getNumber(HttpServletRequest request,HttpServletResponse response) throws IOException {
		response.setContentType(
				"text/html;charset=utf-8");
		PrintWriter out = 
				response.getWriter();
		
		//返回一个随机整数
		Random r = new Random();
		int number = r.nextInt(9999);
		System.out.println("number:" + number);
		out.println(number);
	}
	
	
}

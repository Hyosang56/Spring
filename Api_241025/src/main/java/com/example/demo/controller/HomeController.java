package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.kakaoApi.Documents;
import com.example.demo.kakaoApi.kakaoApiService;

@Controller
public class HomeController {
	@Autowired
	private kakaoApiService kakaoApiService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/searchNodeByKeyword")
	@ResponseBody
	// @ResponseBody가 없으면 String이 페이지인데
	// @ResponseBody 때문에 호출되는 메서드에 리턴값이 데이터로 반환
	public Documents searchNode(@RequestParam("keyword") String keyword) {
		System.out.println("/searchNodeByKeyword 요청");
		System.out.println("검색어: "+ keyword);
		//keyword를 KAKAO API에 전송
		String result = kakaoApiService.searchplaceByKeyword(keyword);
		//KAKAO API 반환되는 결과값 json
		System.out.println(result);
		//객체 형태로 변환
		return null;
	}
	
}

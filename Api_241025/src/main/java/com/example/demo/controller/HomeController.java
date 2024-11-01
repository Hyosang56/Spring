package com.example.demo.controller;

import java.lang.reflect.Type;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.kakaoApi.Documents;
import com.example.demo.kakaoApi.kakaoApiService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;


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
	public List<Documents> searchNode(@RequestParam("keyword") String keyword) {
		System.out.println("/searchNodeByKeyword 요청");
		//KAKAO API 키워드로 장소 검색하기
		String result = kakaoApiService.searchplaceByKeyword(keyword);
		//String >> JsonObject 변환
		Gson gson = new Gson();
		JsonObject docs = JsonParser.parseString(result).getAsJsonObject();
		// JsonObject의 key("documents")에 대한 value 수집
		JsonArray documentArray = docs.get("documents").getAsJsonArray();
		// JsonObjects >> Documents 형태 변환
		Type listType = new TypeToken< List<Documents> >() {}.getType();
		List<Documents> documentList = gson.fromJson(documentArray, listType);
		return documentList;
	}
	
}

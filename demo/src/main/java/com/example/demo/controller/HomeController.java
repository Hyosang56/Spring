package com.example.demo.controller;

import java.awt.Point;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.kakaoApi.Documents;
import com.example.demo.kakaoApi.KakaoApiService;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

@Controller
public class HomeController {
	@Autowired
	private KakaoApiService kakaoApiService;
	
	@GetMapping("/")
	public String home() {
		return "home"; 
	}
	
	@GetMapping("/searchNodeByKeyword")
	@ResponseBody
	public List<Documents> searchNode(@RequestParam("keyword") String keyword,
			                          @RequestParam("category") String category) {
		System.out.println("/searchNodeByKeyword 요청" );
		System.out.println("keyword : " + keyword);
		System.out.println("category : " + category);
		//KAKAO API ( 키워드로 장소 검색하기 )
		String result = kakaoApiService.searchPlaceByKeyword(keyword, category);
		//String >> JsonObject 변환
		Gson gson = new Gson();
		JsonObject docs = JsonParser.parseString(result).getAsJsonObject();
		// JsonObject의 key("documents")에 대한 value 수집
		JsonArray documentArray = docs.get("documents").getAsJsonArray();
		// JsonObject >> Documents 형변환
		Type listType = new TypeToken< List<Documents> >(){}.getType();
		List<Documents> documentList = gson.fromJson(documentArray, listType);
		return documentList;
	}
	
	@PostMapping("/findRoutes")
	
	
	@ResponseBody
	public String findRoute(@RequestBody List<Point> points)  {
		for(Point nodePoint: points) {
			System.out.println("x: "+nodePoint.getX()
						+", y: "+nodePoint.getY() 
						+", 이름: "+nodePoint.getPlaceName());
		}
		
		return null;
	}
	
	
	
	
}








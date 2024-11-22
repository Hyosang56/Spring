package com.example.demo.controller;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.kakaoApi.Documents;
import com.example.demo.kakaoApi.KakaoApiService;
import com.example.demo.kakaoApi.Point;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
	public List<Point> findRoute(@RequestBody List<Point> points  ) {
		
		List<Point> roadPoints = new ArrayList<>();
		
		for(int i = 1; i < points.size(); i++) {
			System.out.println("출발지_index : "+ (i-1) + ", 도착지_index : " + i);
			String res = kakaoApiService.findDirections(points.get( (i-1) ), points.get(i));
			// 도로 이동경로 vertexes 항목을 분류
			// res를 JsonObject 변환 ( Gson 사용 )
			Gson gson = new Gson();
			JsonObject res_Obj = JsonParser.parseString(res).getAsJsonObject();
			// 응답 객체에 key(routes)에 대한 value
			JsonArray routes = res_Obj.get("routes").getAsJsonArray();
			// routes의 0번 인덱스 지정 >> key(sections)에 대한 value
			JsonArray sections = routes.get(0).getAsJsonObject()
					                   .get("sections").getAsJsonArray();
			// sections의 0번 인덱스 지정 >> key(roads)에 대한 value
			JsonArray roads = sections.get(0).getAsJsonObject()
					                  .get("roads").getAsJsonArray();
			
			for(int j=0; j < roads.size(); j++) {
				
				JsonArray vertexes = roads.get(j).getAsJsonObject()
						.get("vertexes").getAsJsonArray();
				for(int idx = 0; idx < vertexes.size(); idx++) {
					Point point = new Point();
					point.setX(vertexes.get( idx ).toString());  //0, 2
					point.setY(vertexes.get( ++idx ).toString());//1, 3
					System.out.println("("+ point.getX()+","+point.getY()+")" );
					roadPoints.add(point);
				}
			}
		}
		return roadPoints;
	}
	
	
	
	
}








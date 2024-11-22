package com.example.demo.kakaoApi;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.springframework.stereotype.Service;

@Service
public class KakaoApiService {
	
	private final String KAKAO_API_KEY = "6d7223429489d2a7ed743d527a0ff330";
	
	// 카카오API 키워드 기반의 장소 검색 요청
	public String searchPlaceByKeyword(String keyword, String category) {
		String response_json = null; // 카카오API에서 반환해주는 결과값
		//httpclient
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
			// 요청URL, 요청파라메터 httpGet 객체 생성
		    ClassicHttpRequest httpGet = ClassicRequestBuilder.get("https://dapi.kakao.com/v2/local/search/keyword.json")
		    												  .addParameter("query", keyword)
		    												  .addParameter("category_group_code", category)
		                                                      .build();
		    // 헤더 설정
		    httpGet.setHeader("Authorization", "KakaoAK "+KAKAO_API_KEY);
		    
		    // 요청 실행
		    response_json = httpclient.execute(httpGet, response -> {
		        System.out.println(response.getCode() + " " + response.getReasonPhrase());
		        final HttpEntity entity1 = response.getEntity();
		        String responseData = EntityUtils.toString(entity1, "UTF-8");
		        EntityUtils.consume(entity1);
		        return responseData;
		    });
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response_json;
	}
	
	// 카카오 모빌리티_자동차 길찾기
	public String findDirections(Point start, Point end) {
		System.out.println("출발지 : " + start.getPlaceName() + ", 도착지 : " + end.getPlaceName());
		System.out.println("출발지X : " + start.getX() + ", 출발지Y : " + start.getY());
		String result = null; // 응답 데이터
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
		    //요청URL, 파라메터 작성
			ClassicHttpRequest httpGet = ClassicRequestBuilder.get("https://apis-navi.kakaomobility.com/v1/directions")
		    		                      .addParameter("origin", start.getX()+","+start.getY())
		    		                      .addParameter("destination", end.getX()+","+end.getY())
		                                  .build();
		    //헤더 설정
			httpGet.setHeader("Authorization", "KakaoAK "+KAKAO_API_KEY);
			httpGet.setHeader("Content-Type", "application/json");
		    
		    result = httpclient.execute(httpGet, response -> {
		        System.out.println(response.getCode() + " " + response.getReasonPhrase());
		        final HttpEntity entity1 = response.getEntity();
		        String responseData = EntityUtils.toString(entity1, "UTF-8");
		        EntityUtils.consume(entity1);
		        return responseData;
		    });
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public String getRequestSample() {
		String result = null; // 응답 데이터
		try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
		    //요청URL, 파라메터 작성
			ClassicHttpRequest httpGet = ClassicRequestBuilder.get("요청URL")
		    		                      .addParameter("파라메터명", "파라메터값")
		    		                      .addParameter("파라메터명", "파라메터값")
		                                  .build();
		    //헤더 설정
			httpGet.setHeader("이름", "값");
			httpGet.setHeader("이름", "값");
		    
		    result = httpclient.execute(httpGet, response -> {
		        System.out.println(response.getCode() + " " + response.getReasonPhrase());
		        final HttpEntity entity1 = response.getEntity();
		        String responseData = EntityUtils.toString(entity1, "UTF-8");
		        EntityUtils.consume(entity1);
		        return responseData;
		    });
		} catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	

}












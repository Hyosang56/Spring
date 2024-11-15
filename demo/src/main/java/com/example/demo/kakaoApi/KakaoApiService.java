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
		    httpGet.setHeader("Authorization", "KakaoAK 6d7223429489d2a7ed743d527a0ff330");
		    
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
	
	
	

}





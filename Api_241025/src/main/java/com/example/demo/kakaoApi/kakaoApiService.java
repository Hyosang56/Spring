package com.example.demo.kakaoApi;

import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.springframework.stereotype.Service;

@Service
public class kakaoApiService {
	public String searchplaceByKeyword(String keyword) {
	String response_json = null; //카카오에서 변환해주는 값
	
	try (CloseableHttpClient httpclient = HttpClients.createDefault()) {
	    // 요청URL, 요청파라메터 작성
		ClassicHttpRequest httpGet = ClassicRequestBuilder.get("https://dapi.kakao.com/v2/local/search/keyword.json")
	            												.addParameter("query", keyword)
	            												//.addParameter("param2", "값2")
	            												.build();
		// 헤더 설정
	    httpGet.setHeader("Authorization","KakaoAK 9f21964cbe91f5dda5c2a935e8ddcc6c");
	    
	    // 요청 실행
	   response_json =  httpclient.execute(httpGet, response -> {
	        System.out.println(response.getCode() + " " + response.getReasonPhrase());
	        final HttpEntity entity1 = response.getEntity();
	        String responseData = EntityUtils.toString(entity1, "UTF-8");
	        EntityUtils.consume(entity1);
	        return responseData;
	    });
		}  catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return response_json;
	
	}
}

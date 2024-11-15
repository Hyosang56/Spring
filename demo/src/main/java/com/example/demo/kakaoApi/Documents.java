package com.example.demo.kakaoApi;

import lombok.Getter;
import lombok.Setter;
 
@Getter @Setter
public class Documents {
	    
	private String address_name;
	private String category_group_code;
	private String category_group_name;
	private String category_name;
	private String distance;
	private String id;
	private String phone;
	private String place_name;
	private String place_url;
	private String road_address_name;
	private String x;
	private String y;
	
}
/*
    {
      "address_name": "인천 미추홀구 주안동 30-1",
      "category_group_code": "",
      "category_group_name": "",
      "category_name": "여행 > 관광,명소 > 광장",
      "distance": "",
      "id": "1101628494",
      "phone": "",
      "place_name": "주안역 북광장",
      "place_url": "http://place.map.kakao.com/1101628494",
      "road_address_name": "인천 미추홀구 염창로 58",
      "x": "126.680076629649",
      "y": "37.4655401259639"
    }  
 * */
 
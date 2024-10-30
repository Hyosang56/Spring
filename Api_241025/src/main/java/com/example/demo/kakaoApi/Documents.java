package com.example.demo.kakaoApi;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
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
	 * {
      "address_name": "인천 남동구 장수동 산 78",
      "category_group_code": "AT4",
      "category_group_name": "관광명소",
      "category_name": "여행 > 관광,명소 > 테마파크",
      "distance": "",
      "id": "11320114",
      "phone": "",
      "place_name": "인천대공원",
      "place_url": "http://place.map.kakao.com/11320114",
      "road_address_name": "인천 남동구 무네미로 238",
      "x": "126.76060470317374",
      "y": "37.45659085797083"
    }
	 * */



package com.crawling.springboot.data;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Builder  // 값을 주입하여 객체를 만들어주기 위한 어노테이션
@Getter // 값을 가져오기 위한 어노테이션
public class KoreaStats {
	private String country; // 시도명
	
	private int diffFromPrevDay; // 전일대비확진환자증감
	
	private int total; // 확진환자수
	
	private int death; // 사망자수
	
	private double incidence; // 발병률
	
	private int inspection; // 일일 검사환자 수

}

package com.crawling.springboot.data;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Data
@Getter  // 선언된 모든 필드의 get 메소드 생성
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="vaccination_center")
//@RequiredArgsConstructor  // 선언된 모든 final 필드가 포함 된 생성자 생성
public class VaccinationStats {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) // mysql의 AUTO_INCREMENT를 그대로 사용
	private String id; //id
	
	@Column
	private String address; // 주소

	@Column
	private String centerName; //센터명
	
	@Column
	private String centerType; //센터타입
	
	@Column
	private String createdAt; // 등록일
	
	@Column
	private String facilityName; //시설명
	
	@Column
	private double lat; //위도
	
	@Column
	private double lng; //경도
	
	@Column
	private String org; //조직명

	@Column
	private String phoneNumber; //전화번호
	
	@Column
	private String sido; // 시도
	
	@Column
	private String sigungu; //시군구
	
	@Column
	private String updatedAt; //수정일
	
	@Column
	private String zipCode; //우편번호
	
}

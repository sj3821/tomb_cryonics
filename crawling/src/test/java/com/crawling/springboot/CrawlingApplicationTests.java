package com.crawling.springboot;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.crawling.springboot.data.KoreaStats;
import com.crawling.springboot.service.CoronaVirusDataService;


@SpringBootTest
class CrawlingApplicationTests {
	
	@Autowired
	CoronaVirusDataService coronaVirusDataService;
/*
	@Test
	public void getKoreaCovideDatas_Test() throws IOException{
		// given
		List<KoreaStats> coronaList = new ArrayList();
		
		// when
		coronaList = coronaVirusDataService.getKoreaCovidDatas();
		
		// then
		assertThat(coronaList.get(0).getCountry()).isEqualTo("합계");
		assertThat(coronaList.get(0).getTotal()).isGreaterThan(0);
		
	}
	*/

}

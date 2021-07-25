package com.crawling.springboot.data;
import org.springframework.data.jpa.repository.JpaRepository;

public interface centerRepository  extends JpaRepository<VaccinationStats,String> {
	VaccinationStats findByName(String id);
	

}

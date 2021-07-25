package com.crawling.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crawling.springboot.data.VaccinationStats;
import com.crawling.springboot.data.centerRepository;

@Service
public class DbService {

	@Autowired
	public centerRepository repository;
	
	public List<VaccinationStats> saveCenters(List<VaccinationStats> VaccinationStats){
		return repository.saveAll(VaccinationStats);
	}
	
	 
}

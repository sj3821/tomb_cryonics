package com.crawling.springboot.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crawling.springboot.data.VaccinationStats;
import com.crawling.springboot.service.CoronaVaccinationDataService;

@Controller
@RequestMapping("/api")
public class ApiController {
	@GetMapping("/Vaccination_info/basic")
	public String vaccinationInfoBasic(Model model) throws Exception {
        List<VaccinationStats> vaccinationStatsList = CoronaVaccinationDataService.getVaccionationDatas();
        model.addAttribute("vaccinationStatsList", vaccinationStatsList);
        return "vaccination";
    }
}

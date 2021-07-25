package com.crawling.springboot.Controller;


import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.crawling.springboot.data.KoreaStats;
import com.crawling.springboot.service.CoronaVirusDataService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class WebController {
	
	@RequestMapping("/")
	@ResponseBody
	public String home(){
		return "helloHome";
	}
	/*
	@RequestMapping("/jsp")
	public String jspPage(Model model){
		model.addAttribute("name","hello springBoot1234");
		return "hello";
	}
	*/
/*	
   private final CoronaVirusDataService coronaVirusDataService;

    @GetMapping("/korea")
    public String korea(Model model) throws IOException {

        List<KoreaStats> koreaStatsList = coronaVirusDataService.getKoreaCovidDatas();

        model.addAttribute("koreaStats", koreaStatsList);

        return "korea";

    }
    */
    /*
    @GetMapping("/test")
    public String test(Model model) throws IOException{
    	return "test";
    }
*/

}

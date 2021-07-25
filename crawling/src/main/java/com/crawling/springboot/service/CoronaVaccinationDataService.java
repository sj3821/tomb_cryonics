package com.crawling.springboot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.crawling.springboot.data.VaccinationStats;

public class CoronaVaccinationDataService {
	
	public static List<VaccinationStats> getVaccionationDatas() throws IOException {
		
		 List<VaccinationStats> vaccinationList = new ArrayList<>();
		
		 JSONParser jsonparser = new JSONParser();
         JSONObject jsonobject;
		try {
			jsonobject = (JSONObject)jsonparser.parse(readPublicApi());
//	         System.out.println("---------JSONOBJECT----------------------");
//	         System.out.println(jsonobject);
	         /*JSONObject json =  (JSONObject) jsonobject.get("data");
	         System.out.println("---------json----------------------");
	         System.out.println(json);
	         */
	         JSONArray array = (JSONArray)jsonobject.get("data");
//	         System.out.println("---------JSONarray----------------------");
//	         System.out.println(array);

	         for(int i = 0 ; i < array.size(); i++){
	             JSONObject entity = (JSONObject)array.get(i);
//		         System.out.println("---------entity----------------------");
//		         System.out.println(entity);
		         
		         VaccinationStats vaccinationStats = VaccinationStats.builder()
		        		 		.address(entity.get("address").toString())
		        		 		.id(entity.get("id").toString())
		        		 		.centerName(entity.get("centerName").toString())
		        		 		.centerType(entity.get("centerType").toString())
		        		 		.createdAt(entity.get("createdAt").toString())
		        		 		.facilityName(entity.get("facilityName").toString())
		        		 		.lat(Double.parseDouble(entity.get("lat").toString()))
		        		 		.lng(Double.parseDouble(entity.get("lng").toString()))
		        		 		.org(entity.get("org").toString())
		        		 		.phoneNumber(entity.get("phoneNumber").toString())
		        		 		.sido(entity.get("sido").toString())
		        		 		.sigungu(entity.get("sigungu").toString())
		        		 		.updatedAt(entity.get("updatedAt").toString())
		        		 		.zipCode(entity.get("zipCode").toString())
		        		 		.build();
		         
		         vaccinationList.add(vaccinationStats);
	         }
	         DbService dbService = new DbService();
				//	         System.out.println("-------------------------");
//	         for(int i = 0 ; i < vaccinationList.size(); i++){
//	         System.out.println(vaccinationList.get(i).getCenterName());
//	         }
	        	
	         try {	
	        	 dbService.saveCenters(vaccinationList);
	        	
	         }
	         catch(Exception e){
	        	 
	         }
	         
			return vaccinationList;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}   
	}
	
	
	public static String readPublicApi() {
		StringBuffer result = new StringBuffer();
		try {
			String page="1";
			String perPage = "284";
			String totalCount = "";
			String serviceKey = "";
			StringBuilder urlBuilder = new StringBuilder("https://api.odcloud.kr/api/15077586/v1/centers");
			urlBuilder.append("?" + URLEncoder.encode("page","UTF-8")+ "=" + URLEncoder.encode(page,"UTF-8")); /*페이지번호*/
			urlBuilder.append("&" + URLEncoder.encode("perPage","UTF-8")+ "=" + URLEncoder.encode(perPage,"UTF-8")); /*페이지당 결과수*/
			urlBuilder.append("&"+ URLEncoder.encode("serviceKey","UTF-8") + "=" +serviceKey ); /*ServiceKey*/
			
			
			URL url = new URL(urlBuilder.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			
			BufferedReader rd;
			if(conn.getResponseCode() >= 200 && conn.getResponseCode() <=300) {
				rd = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			} else {
				rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder(); 
			String line; 
			while ((line = rd.readLine()) != null) { 
				sb.append(line); 
			}
			
			rd.close();
			conn.disconnect();
			
			String apiResult = sb.toString();
			System.out.println("-----apiResult-------------");
			System.out.println(apiResult);
			return apiResult;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

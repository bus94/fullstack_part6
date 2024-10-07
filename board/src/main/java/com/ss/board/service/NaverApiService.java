package com.ss.board.service;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NaverApiService {
	@Value("${naver.client.id}")
	private String clientId;

	@Value("${naver.client.secret}")
	private String clientSecret;

	private RestTemplate rest;
	
	// 크롤링하여 데이터 추출 후 요약하는 메서드
	public String craw() {
		String text = "";
		
		try {
			String url = "https://n.news.naver.com/mnews/article/001/0014928255";
			
			// json 사이트 문서 가져오기
			Document doc = Jsoup.connect(url).get();
			
			// 원하는 요소 선택하기!
			Element content = doc.select("article#dic_area").first();
			System.out.println("크롤링: " + content);
			text = content.text();
			System.out.println("텍스트: " + text);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return text;
	}
	
	public String getSummary() {
		// 결과를 담아주는 변수를 생성
		String summary = "";

		String text = craw();
		
		// url
		String urlApi = "https://naveropenapi.apigw.ntruss.com/text-summary/v1/summarize";
		try {
			rest = new RestTemplate();

			// 요청헤더
			HttpHeaders headers = new HttpHeaders();

			headers.set("X-NCP-APIGW-API-KEY-ID", clientId);
			headers.set("X-NCP-APIGW-API-KEY", clientSecret);
			headers.set("Content-Type", "application/json");

			// 요청바디
			Map<String, Object> document = new HashMap<String, Object>();
			document.put("title", "");
			document.put("content", text);

			Map<String, Object> option = new HashMap<String, Object>();
			option.put("language", "ko");
			option.put("model", "news");
			option.put("tone", 2);
			option.put("summaryCount", 2);

			// 위에서 설정한 두 내용을 합치기
			Map<String, Object> requestBody = new HashMap<String, Object>();
			requestBody.put("document", document);
			requestBody.put("option", option);

			// 헤더랑 바디랑 합쳐서 전송하기
			HttpEntity<Map<String, Object>> request = new HttpEntity<Map<String, Object>>(requestBody, headers);
			// 전송해서 응답받기
			ResponseEntity<String> resp = rest.exchange(urlApi, HttpMethod.POST, request, String.class);
			System.out.println("응답: " + resp.getBody());

			// JSON 파싱
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(resp.getBody());

			// "summary" 키워드 추출
			summary = (String) jsonObject.get("summary");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return summary;
	}
}

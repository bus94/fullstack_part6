package com.ss.thymeleaf.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.thymeleaf.dto.Item;
import com.ss.thymeleaf.dto.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller		// return 할 때 기본적으로 뷰페이지 파일명을 이용해서 뷰리졸버 경로 설정해서 뷰페이지로 이동할 수 있도록 만들어주는 역할!
public class HomeController {
	@GetMapping("/main.do")
	public String mainPage(Model model) {
		log.info("타임리프 main() 실행");
		
		model.addAttribute("username", "이익준");
		model.addAttribute("data", "Hello <b>Spring boot!</b>");
		
		return "thymeleafEx1";
	}
	
	@GetMapping("/main2.do")
	public String main2(Model model) {
		log.info("타임리프 main2() 실행");
		
		model.addAttribute("num1", 10);
		model.addAttribute("num2", 20);
		model.addAttribute("person", new Person("익준", 30));
	
		// 리스트
		List<String> items = Arrays.asList("spring", "springboot", "AWS");
		model.addAttribute("list", items);
		
		// map
		Map<String, Integer> scoreList = new HashMap<String, Integer>();
		scoreList.put("익준", 90);
		scoreList.put("준완", 100);
		scoreList.put("송화", 95);
		model.addAttribute("scoremap", scoreList);
		
		 // list, map
		List<Map<String, Integer>> listMap = new ArrayList<Map<String, Integer>>();
		
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("A", 10);
		map1.put("B", 20);
		map1.put("C", 30);
		listMap.add(map1);
		
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("A2", 40);
		map2.put("B2", 50);
		map2.put("C2", 60);
		listMap.add(map2);
		
		model.addAttribute("listmap", listMap);
		
		// list, map - Person
		List<Map<String, Person>> listPer = new ArrayList<Map<String, Person>>();
		Map<String, Person> map3 = new HashMap<String, Person>();
		map3.put("강동구", new Person("강동구", 24));
		map3.put("강서구", new Person("강서구", 23));
		map3.put("강남구", new Person("강남구", 25));
		map3.put("강북구", new Person("강북구", 21));
		listPer.add(map3);
		
		model.addAttribute("listper", listPer);
		
		return "thymeleafEx2";
	}
	
	@GetMapping("/main3.do")
	public String main3(Model model) {
		log.info("타임리프 main3() 실행");
		
		// if문 데이터
		model.addAttribute("isAdmin", true);
		model.addAttribute("isAdmin1", false);
		model.addAttribute("age", 20);
		model.addAttribute("role", "user");
		model.addAttribute("person", new Person("익준", 20));
		
		return "thymeleafEx3";
	}
	
	@GetMapping("/main4.do")
	public String main4(Model model) {
		log.info("타임리프 main4() 실행");
		
		List<String> items = Arrays.asList("qwer", "asdf", "zxcv");
		model.addAttribute("items", items);
		
		List<String> items2 = new ArrayList<String>();
		model.addAttribute("items2", items2);
		
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("A2", 40);
		map2.put("B2", 50);
		map2.put("C2", 60);
		
		model.addAttribute("map2", map2);
		
		return "thymeleafEx4";
	}
	
	@GetMapping("/main5.do")
	public String main5(Model model) {
		log.info("타임리프 main5() 실행");
		
		Map<String, Integer> mapEmp = new HashMap<String, Integer>();
		mapEmp.put("홍길동", 30);
		mapEmp.put("동해물", 27);
		mapEmp.put("백두산", 35);
		mapEmp.put("마르고", 29);
		model.addAttribute("mapEmp", mapEmp);
		
		List<Map<String, Item>> itemList = new ArrayList<Map<String,Item>>();
		Map<String, Item> mapItem = new HashMap<String, Item>();
		mapItem.put("볼펜", new Item("볼펜", 12000, "pen"));
		mapItem.put("연필", new Item("연필", 2500, "pen"));
		mapItem.put("노트", new Item("노트", 5000, "book"));
		mapItem.put("지우개", new Item("지우개", 1000, "eraser"));
		mapItem.put("국어사전", new Item("국어사전", 35000, "book"));
		itemList.add(mapItem);
		model.addAttribute("itemList", itemList);
		System.out.println("itemList: " + itemList);
		
		return "test";
	}
	
	@GetMapping("/main6.do")
	public String main(Model model) {
		log.info("타임리프 main6() 실행");
		return "main";
	}
}

/*
 * 타임리프
 * - 자바 웹 어플리케이션 개발에 사용되는 서버 사이드 java 템플릿(뷰 화면을 구성)
 * 	 html, XML, 텍스트, 자바 스크립트, CSS 등 다양하게 마크업 파일을 생성할 수 있다.
 * - 동적인 뷰를 생성할 수 있다.
 * - 네츄럴 템플릿
 * 		타임리프 템플릿을 실행하지 않은 상태에서도 html 파일로써 자연스럽게 보여질 수 있다.
 * - 스프링에서 타임리프를 적용할 수 있다.
 * 	 메이븐 레파지토리에서 검색해서 사용하면 가능!
 * 
 * 
 */

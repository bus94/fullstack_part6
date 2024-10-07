package com.ss.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ss.jpa.dto.Member;
import com.ss.jpa.repository.MemberRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@Autowired
	private MemberRepository re;
	
	@GetMapping("/jpa")
	public String main(Model model) {
		log.info("main 메서드 실행");
		List<Member> members = null;

		// 아이유를 찾아서 출력하는 프로그램
//		List<Member> members = re.findByName("아이유");
		
		// 이메일 검색
//		members = re.findByEmail("exo@example.com");
//		members = re.getByEmail("exo123@example.com");
//		LocalDateTime date = LocalDateTime.of(2023, 1, 1, 0, 0);
//		members = re.findAllByCreateAtGreaterThanEqualAndName(date, "아이유");
		Long id1 = (long) 3;
		Long id2 = (long) 7;
		members = re.findAllByIdBetweenAndEmailContains(id1, id2, "i");
		
		log.info(members + "");
		
		model.addAttribute("members", members);
		return "main";
	}
}

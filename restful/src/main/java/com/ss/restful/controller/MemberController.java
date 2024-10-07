package com.ss.restful.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ss.restful.entity.Member;
import com.ss.restful.service.MemberService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/member/create")
	public String create() {
		// 1. 웹에서 서버로 전송하는 DTO
		// 2. 엔티티 작성하기
		// 3. 잔디에 테이블 생성 시 참고
		
		/*
		 * 생략하기
		 * STATUS  VARCHAR(1) DEFAULT 'Y' CHECK(STATUS IN('Y', 'N')),
    	 * ENROLL_DATE DATETIME  DEFAULT CURRENT_TIMESTAMP,
    	 * MODIFY_DATE DATETIME DEFAULT CURRENT_TIMESTAMP
		 * 
		 */
		
		// 4. repository 생성
		// 	  타입하고 어떤 내용을 상속 받아야되는지 설정 
		// 5. 뷰 템플릿에서 ajax를 이용해서 DB에 저장하는 내용을 작성하기
		//	  가입하기 버튼을 클릭하면 restcontroller로 이동해서 처리하고 결과를 성공 실패 alert 창 띄우기
		
		return "";
	}
	
//	@PostMapping("/memberEnroll.do")
//	public String memberEnroll(MemberDTO dto) {
////		dto.setNo(1);
//		Member member = dto.toEntity();
//		
//		Member result = memberSql.save(member);
//		
//		log.info(result + "");
//		
//		return "member/main.do";
//	}
	
	// 아이디로 회원 조회
	@GetMapping("/searchId.do")
	public String searchId(Model model, @RequestParam("id") String id) {
		log.info("searchId() 실행");
		log.info(id);
		
		Member mem = memberService.getMemberById(id);
		model.addAttribute("member", mem);
		
		return "main";
	}
	
	// 이메일로 회원 조회
	@GetMapping("/searchEmail.do")
	public String searchEmail(Model model, @RequestParam("email") String email) {
		log.info("searchEmail() 실행");
		log.info(email);
			
		Member mem = memberService.getMemberByEmail(email);
		model.addAttribute("member", mem);
			
		return "main";
	}
	
	// List<Member>
	// 성별은 여러 명이 올 수 있다.
	@GetMapping("/searchGender.do")
	public String searchGender(Model model, @RequestParam("gender") String gender) {
		log.info("searchGender() 실행");
		log.info(gender);
			
		List<Member> members = memberService.getMemberByGender(gender);
		model.addAttribute("members", members);
			
		return "main";
	}
	
	// 취미는 여러 종류가 올 수 있다. 우선은 하나만!
	@GetMapping("/searchHobby.do")
	public String searchHobby(Model model, @RequestParam("hobby") String hobby) {
		log.info("searchHobby() 실행");
		log.info(hobby);
				
		List<Member> members = memberService.getMemberByHobby(hobby);
		model.addAttribute("members", members);
			
		return "main";
	}
	
	@GetMapping("/searchAge.do")
	public String searchAge(Model model, @RequestParam("age") Integer age) {
		log.info("searchAge() 실행");
		log.info(age + "");
				
		List<Member> members = null;
		if(age != null) {
			// 나이를 입력받아서 사용
			members = memberService.getMemberByAgeGreater(age);
		} else {
			members = memberService.getMemberByAge();
		}
		model.addAttribute("members", members);
			
		return "main";
	}
}

package com.ss.thymybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.ss.thymybatis.dto.UserDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FormController {
	@PostMapping("/view1")
	public String view1(UserDTO dto) {
		log.info(dto + "");
		return "post/form1";
	}
}

package com.ss.chatbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ChatController {
	@GetMapping("/chat.do")
	public String chat() {
		return "chat";
	}
}

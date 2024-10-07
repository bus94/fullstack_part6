package com.example.junit.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import lombok.extern.slf4j.Slf4j;

// 단위 테스트
// - 컨트롤러만 테스트
// @WebMvcTest(테스트 할 특정 컨트롤러명.class)


@Slf4j
@WebMvcTest(MyController.class)
public class MyControllerUnitTest {

	@Autowired
	private MockMvc mockMvc;
	
	
	@Test
	public void test() throws Exception {
		log.info("test()실행!");
		// perform() 
		//  - 가짜 Http요청을 만든다.
		//  - 요청을 만든 뒤 통신을 보낸다.
		MvcResult result = mockMvc.perform(get("/hello"))
				// 200 ok응답이 오는지 확인
			   .andExpect(status().isOk())
			   .andExpect(content()
					   .string("Hello, world!"))
			   .andReturn();
		
		// 테스트 도중에 응답한 결과를 
		// 직접 출력하고 싶을 경우 
		// andReturn() 
		// MvcResult객체로 받아온다.
		log.info(result +"");
		
		String conString
			= result
			  .getResponse()
			  .getContentAsString();
		
		log.info("result:" + conString);
		System.out.println("result:" 
						 + conString);
		
		// 상태코드를 반환해서 출력
		int code = result
				  .getResponse()
			      .getStatus();
		
		System.out.println("상태코드:" 
						   + code);
		
		// 헤더(응답헤더)
		String resultHeader= 
		   result
		  .getResponse()
		  .getHeader("Content-Type");
		 
		System.out.println("헤더:"
					+ resultHeader);
		
		//MockHttpServletResponse
		//실제 http응답과 거의 동일한 구조로
		//이루어져있다.
		// 다만 실제 네트워크 통신은 아니다.
		
	}
	
	// Post요청 테스트
	@Test
	public void testPost() throws Exception {
		
		log.info("testPost()실행");
		
		String jsonContent = 
		"{\"name\":\"John\", \"age\":30}";
		
		MvcResult result =
		    mockMvc.perform(post("/create")
		    	   .contentType(MediaType.APPLICATION_JSON) //content-type 지정
		    	   .content(jsonContent)) // 요청바디에 JSON데이터 포함
		    	   .andExpect(status().isOk()) //200 확인
		    	   .andExpect(content().string("created")) //내용확인
		    	   .andReturn();
		    	   
		log.info("post응답내용:"
		  + result.getResponse()
		   .getContentAsString());
		
	}
	
	// Put 요청 
	// 기존에 데이터를 수정하는 요청
	// update/1,2
	@Test
	public void testPut() throws Exception {
		log.info("testPut()실행");
		
		// 업데이트할 가짜 데이터를 생성 
		String jsonContent = 
		"{\"name\":\"John Updated\", \"age\":35}";
		
		//Unhandled exception type Exception
		// 발생하기 때문에 예외처리 해야된다.
		MvcResult result =
			    mockMvc.perform(put("/update/2")
			    	   .contentType(MediaType.APPLICATION_JSON) //content-type 지정
			    	   .content(jsonContent)) // 요청바디에 JSON데이터 포함
			    	   .andExpect(status().isOk()) //200 확인
			    	   .andExpect(content().string("updated")) //내용확인
			    	   .andReturn();
			    	   
			log.info("put응답내용:"
			  + result.getResponse()
			   .getContentAsString());
		
	}
	
	// delete 요청
	// update 요청처럼 id값을 받을 수있도록
	// 컨트롤러를 생성하고 메서드명 delete
	// return 시 바디에 deleted
	// 테스트에서 결과를 확인 출력!
	
	
	
	
}

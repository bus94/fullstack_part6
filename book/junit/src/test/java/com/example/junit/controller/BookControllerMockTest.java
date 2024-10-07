package com.example.junit.controller;

import com.example.junit.entity.Book;
import com.example.junit.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.transaction.annotation.Transactional;

// 모든 트랜잭션 작업이 각각 테스트 종료후 
// 롤백(rollback)한다. 

// 서블릿 테스트 환경 속성을 지정
// webEnvironment = WebEnvironment.MOCK
//  실제 서버를 실행하지 않고 가상적인 처리를 한다.

// webEnvironment = WebEnvironment.RANDOM_PORT
//  스프링부트에서 내장된 서버 톰캣 
//  실제 톰캣을 실행할 때 포트번호를 랜덤설정

//webEnvironment = 
// WebEnvironment.DEFINDE_PORT
// 고정된 포트를 이용해서 실제 서버에서 테스트
// 를 실행할 수있도록! 8080

@Transactional
@AutoConfigureMockMvc // MockMvc를 빈으로 등록해준다.
@SpringBootTest(webEnvironment = WebEnvironment.MOCK) // 가짜 서버를 생성
public class BookControllerMockTest {

	// 객체를 자동으로 생성하고 빈으로 등록해주는
	// 역할 . 실제 서버를 실행하지 않고도
	// HTTP요청을 모의하여 컨트롤러를
	// 테스트 할 수있도록 한다.

	// 자동으로 설정되고 컨트롤러를 테스트한다.
	@Autowired
	private MockMvc mockMvc;

	// 가짜 객체를 생성하는데 mockito
	// 라이브러리에서 제공하는 어노테이션!
	// 가짜 서비스 만들어서 테스트해라!
	@Mock
	private BookService bookService;

	
	@Test
	public void delete_test()
			throws Exception{

	//given
	// 아이디값을 입력 받아서 
	// 어떤 메서드를 호출해서 아이디값을
	// 매개변수로 넘겨주고 thenReturn("ok")
	Long id = 1L;
	when(bookService.삭제하기(id))
	.thenReturn("ok");
	
	//when(실행)
	ResultActions resultAction 
	= mockMvc.perform
			 (delete("/book/{id}",id));
	//then(응답검증)
	resultAction
		.andExpect(status().isOk()) 
		.andDo(print());
	}
	
	
	
	@Test
	public void update_test()
			throws Exception{

	//given
	// 어떤 책을 아이디값으로 조회해서 
	// 수정할 값을 입력 받고 
	// 어떤 메서드가 실행 매개변수로 
    // 어떤 객체와 어떤 변수가 넘어갈 지
	// 응답받는 객체타입을 작성
	Long id = 1L;
	Book updateBook = new Book(null
						,"Junit5실습"
						,"서희");
	String content = new ObjectMapper()
					.writeValueAsString
					       (updateBook);
	when(bookService.수정하기(id,book))
		.thenReturn( new Book(null
						,"Junit5실습"
						,"서희"));	
	//when(실행)
	ResultActions resultAction 
	= mockMvc.perform
			 (put("/book/{id}",id)
			.content(content)
			.contentType(MediaType
					.APPLICATION_JSON));	
	//then(응답검증)
	resultAction
		.andExpect(status().isOk()) 
		.andExpect(jsonPath("$.title")
					.value("Junit5실습"))
		.andDo(print());
	}
		
	@Test
	public void findById_test()
					throws Exception{
		
		//given
		// 어떤 아이디값을 이용해서 
		// 한 건을 가져올 지 결정 
		Long id = 1L;
		// when(어떤호출(id))
		// thenReturn(결과객체)
		
		when(bookService.한건가져오기(id))
		.thenReturn(new Book(1L,"남궁성","자바의 정석"));
				
		//when(실행)
		ResultActions resultAction 
			= mockMvc.perform
					 (get("/book/{id}",id)
					.contentType(MediaType
							.APPLICATION_JSON));

		//then(응답검증)
		resultAction
		.andExpect(status().isOk()) // 상태코드값 확인
		.andExpect(jsonPath("$.title")
						.value("자바의 정석"))
		.andDo(print());
	}
	
	
	@Test
	public void findAll_test() throws Exception {
		// given
		// 1. 초기 데이터를 준비
		List<Book> books = new ArrayList<Book>();
		books.add(new Book(1L, "스프링부트", "쌍용"));
		books.add(new Book(2L, "리액트", "쌍용"));

		// 2. 어떤 행동을 할 지 설정!
		when(bookService.findAll()).thenReturn(books);

		// when (실제 실행)
		// 3. 가짜 Http요청
		ResultActions resultAction = mockMvc.perform(get("/book").contentType(MediaType.APPLICATION_JSON));

		// then (결과 응답 검증)
		resultAction.andExpect(status().isOk()) // 상태코드값 확인
				.andExpect(jsonPath("$.[0].title")
									.value("자바의 정석"))
				.andDo(print());

		resultAction
			.andExpect(status().isOk())
		    .andDo(MockMvcResultHandlers
				    		.print());
	
	}

	@Test
	public void jsonPathTest2() throws Exception {
		// 서버에서 응답 JSON 배열
		String jsonResponse = "[{ \"id\": 1, \"name\": \"John\" }, { \"id\": 2, \"name\": \"Jane\" }]";

		// get요청 후 검증
		mockMvc.perform(get("/users")).andExpect(status().isOk())
				// id 값이 1인지 검증
				.andExpect(jsonPath("$[0].id").value(1)).andExpect(jsonPath("$[1].name").value("aa"))
				// 배열의 사이즈가 맞는지 검증
				.andExpect(jsonPath("$", Matchers.hasSize(2))).andDo(print());

	}

	@Test
	public void jsonPathTest1() throws Exception {

		// 서버가 응답을 받아서 저장한 후
		String respJson = "{\"id\": 1, \"name\":\"aa\"}";

		// get요청후 검증
		mockMvc.perform(get("/user1")).andExpect(status().isOk())
				// id 값이 1인지 검증
				.andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.name").value("aa")).andDo(print());
	}

	@Test
	public void save_test() throws Exception {
		System.out.println("save_test()실행");

		// given
		// - Book 객체를 저장하기
		// 위해서 저장을 했을 때 어떤
		// 결과가 나올지 설정하는 부분
		Book book = new Book(null, "스프링부트", "쌍용");
		// 자바 객체를 JSON형식으로 변환해준다.
		// 문자열로 저장할 수있도록!
		// writeValueAsString(객체) {"title":"스프링부트"}
		// 이런 형태로 변환이 된다.
		String content = new ObjectMapper().writeValueAsString(book);

		// 특정 메서드가 호출되어서 실행할 수있도록
		// 설정
		when(bookService.저장하기(book)).thenReturn(new Book(null, "스프링부트", "쌍용"));

		// when
		// http요청 보낸다.
		ResultActions resultAction = mockMvc
				.perform(post("/book").contentType(MediaType.APPLICATION_JSON).content(content));

		// then 응답 상태 201
		resultAction.andExpect(status().isCreated()).andExpect(jsonPath("$.title").value("스프링부트"));

		// 실행순서
		// 1. 책의 객체를 생성
		// 2. JSON변환
		// 3. Mockito로 서비스 동작설정

		// 4. 가상의 Http post요청

		// 5. 응답 상태 검증
		// 6. 응답 본문 검증

	}
}
/*
 * BDD(Behavior-Driven Development) 주어졌을 때 , 이럴 때 이런 결과가 나와야한다. 테스트하는 방법 -
 * given(준비) 테스트에 필요한 데이터나 상활을 설정
 * 
 * - when(실행) 테스트할 행동을 정의하는부분 실제로 API요청을 보내는 것!
 * 
 * - then(검증) 응답결와 예상한 값이 일치하는지 검증하는 것!
 * 
 */

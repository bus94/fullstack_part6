package com.ss.junit.exception;

//예외를 직접 만들어서 처리
public class BookNotFoundException extends RuntimeException{
	// 구체적으로 예외를 처리할 때
	public BookNotFoundException(String msg) {
		super(msg);
	}
}

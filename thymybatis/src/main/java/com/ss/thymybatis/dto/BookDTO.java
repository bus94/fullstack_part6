package com.ss.thymybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {
	private Long idx;
	private String title;
	private String author;
	private String publisher;
	private String publisherDate;
}

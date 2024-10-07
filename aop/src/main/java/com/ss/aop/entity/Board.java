package com.ss.aop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
// @Table(name="BOARD") 생략 가능
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NO")
	private Integer no;

	@Column(name = "BOARD_NO")
	private Long boardNo;

	@Column(name = "WRITER_NO")
	private Long writerNo;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "CONTENT")
	private String content;

	@Column(name = "TYPE")
	private String type;

	@Column(name = "ORIGINAL_FILENAME")
	private String originalFilename;

	@Column(name = "RENAMED_FILENAME")
	private String renamedFilename;

	@Column(name = "READCOUNT")
	private Integer readCount;

	@Column(name = "STATUS")
	private String status;

	// 자바에서 사용하는 Date, Calendar 타입은 DB에 시간만, 날짜만, 시간과 날짜 두 개 다 저장할 지 명확하게 지정 하지 않으면
	// 예외 발생할 수 있다.
	// @Temporal(TemporalType.TIMESTAMP)
	// TemporalType 3가지
	// date: 날짜만, time : 시간만, TIMESTAMP 둘다 저장(yyyy-MM-dd HH:mm:ss)
	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "MODIFY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}

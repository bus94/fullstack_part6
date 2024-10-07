package com.ss.board.entity;

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
@Entity
public class Board {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NO")
	private Long no;

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

	@Column(name = "CREATE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(name = "MODIFY_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifyDate;
}

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//private Long id;
//
//@Column
//private String title;
//private String content;
//private String type;
//private String original_filename;
//private String renamed_filename;
//private String status;
//private String create_date;
//private String modify_date;
//
//@ManyToOne
//@JoinColumn(name = "writer_no")
//private Writer writer;
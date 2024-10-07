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
public class Reply {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="NO")
	private Integer no;
	@Column(name = "BOARD_NO")
    private Long boardNo;

    @Column(name = "WRITER_NO")
    private Long writerNo;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "STATUS")
    private String status;
    
    @Column(name ="CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    @Column(name ="MODIFY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
}

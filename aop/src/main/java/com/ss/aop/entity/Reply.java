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
//@Table(name="REPLY") 생략 가능
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
    
    // 자바에서 사용하는 Date,Calender
    // 타입은 데이터베이스에 시간만 ,날짜만,
    // 시간과 날짜를 두개 다 저장할 지 명확하게
    // 지정을 하지않으면 예외가 발생할 수있다.
    //  @Temporal(TemporalType.TIMESTAMP)
    //   TemporalType타입이 3가지
    //   date: 날짜만 time : 시간만
    //  TIMESTAMP 둘다 저장(yyyy-MM-dd HH:mm:ss)
    @Column(name ="CREATE_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    
    @Column(name ="MODIFY_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifyDate;
}

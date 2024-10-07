//package com.ss.chatbot.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity
//public class Order { // 주문 클래스
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	private Long id;
//	private String product;
//	
////	// Order 클래스 입장에서는 여러 개의 주문이 하나의 고객과 연결될 수 있다.
////	@ManyToOne // 주문은 여러 개하는 한 명의 고객 (Order: Many 입장, Customer: One 입장)
////	@JoinColumn(name="customer_id")
////	private Customer customer; // 주문한 고객
//}

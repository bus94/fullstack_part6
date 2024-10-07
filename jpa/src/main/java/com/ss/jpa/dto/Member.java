package com.ss.jpa.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity // springboot가 실행될 때 테이블로 만들어진다.
		// 엔티티 어노테이션이 붙은 클래스 이름으로 자동으로 테이블 생성
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "member") // table의 이름을 지정할 수 있다. (컬럼도 마찬가지로 가능하다)
public class Member {
	// @Entity 필요
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	// nullable 속성, length 속성을 하면 name은 필수이며, 최대 길이가 100
	// @Column(nullable = false, length = 100)
	// 		nullable 속성값을 false로 지정하면 null값을 허용하지 않는 필드로 만들 수 있다.
	//		length 속성으로 필드의 크기를 지정할 수 있다.
	//			varchar(100) 이라는 의미와 같다.
	//		unique 속성값을 true로 지정하면 중복되는 값을 허용하지 않는 필드로 만들 수 있다.
	// @Column(name = "nick", nullable = false, length = 100, unique = true) // 한 번에 작성할 수 있다.
	private String name;
	// @Column(nullable = false, unique = true)
	private String email;
	
	// @Column 어노테이션 붙은 필드는 테이블 구성하는 멤버로 사용된다. 기본적으로 entity 어노테이션이 붙으면 생략 가능하다!
	//			name 속성으로 멤버 이름과 다른 필드 이름을 지정할 수 있다. ex) @Column(속성 key = value)
	// @Column(updatable = false) // update sql 명령이 실행할 때 제외
	@Column(name="create_at")
	private LocalDateTime createAt;
	// @Column(insertable = false) // insert sql 명령이 실행할 때 제외
	@Column(name="update_at")
	private LocalDateTime updateAt;
	@Column(name = "create_content") // name 속성을 이용하여 sql의 column명을 지정해줄 수 있다. 
	private String createContent;
}

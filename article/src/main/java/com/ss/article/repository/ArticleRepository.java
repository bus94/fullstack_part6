package com.ss.article.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.article.entity.Article;

// spring doot의 JPA에서 entity의 기본적인 CRUD가 가능하도록 REpository 제공한다.
// JPA는 데이터베이스에 적용할 메서드를 정의해놓고 spring boot가 Repositiory가 내부 구현체를 자동으로 생성시켜 사용하기 때문에 별도의 구현체를 따로 생성하지 않아도 된다.

// JpaRepository 인터페이스 상속 받아서 사용할 타입을 지정한다.
// 제네릭 타입으로 그때 그때 마다 개발자가 사용하는 테이블 타입이 다를 수 있기 때문에 컴파일시에 main에서 작성한 타입으로 jpa메서드 타입을 결정한다.

// 첫 번째 제네릭 타입은 entity 타입을 작성
// 두 번째 제네릭 타입은 기본키 타입을 작성
public interface ArticleRepository extends JpaRepository<Article, Long>{
	
}

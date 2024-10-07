package com.ss.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ss.mybatis.dto.Article;

@Repository	  // DB 접근하는 클래스
@Mapper       // sqlSession정보를 가지고온다.
public interface ArticleMapper {
	// 전체 조회
	List<Article> findArticles();

	// 한 건 조회
	Article findById(Long id);
}

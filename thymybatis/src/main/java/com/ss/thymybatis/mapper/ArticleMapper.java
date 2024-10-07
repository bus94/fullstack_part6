package com.ss.thymybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ss.thymybatis.dto.Article;
import com.ss.thymybatis.dto.Comment;

@Mapper
public interface ArticleMapper {

	// 전체 조회
	List<Article> findAll();

	// id로 조회
	Article findById(int id);

	// 수정
	void update(Article article);

	// 댓글 추가
	void insertComment(Comment comment);

	// 댓글 리스트 불러오기
	List<Comment> commentList(int id);

	// 댓글 수정
	int commentUpdate(Comment comment);

	// 수정된 댓글 한 건 조회
	Comment updateNew(int id);

	// 댓글 삭제
	Comment commentDelete(int id);

	
}

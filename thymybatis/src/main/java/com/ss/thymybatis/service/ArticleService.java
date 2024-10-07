package com.ss.thymybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.thymybatis.dto.Article;
import com.ss.thymybatis.dto.Comment;
import com.ss.thymybatis.mapper.ArticleMapper;

@Service
public class ArticleService {
	@Autowired
	private ArticleMapper mapper;
	
	// 전체 게시글 불러오기
	public List<Article> findAll() {
		return mapper.findAll(); 
	}

	// 해당 id 게시글 불러오기
	public Article findById(int id) {
		return mapper.findById(id);
	}

	// 게시글 수정
	public void update(Article article) {
		mapper.update(article);
	}

	// 댓글 저장
	public void insertComment(Comment comment) {
		mapper.insertComment(comment);
	}

	// 댓글 리스트 가져오기
	public List<Comment> commentList(int id) {
		return mapper.commentList(id);
	}

	// 댓글 수정
	public int commentUpdate(Comment comment) {
		return mapper.commentUpdate(comment);
	}

	// 수정된 댓글 한 건 가져오기
	public Comment updateNew(int id) {
		return mapper.updateNew(id);
	}
	
	// 댓글 삭제
	public Comment commentDelete(int id) {
		return mapper.commentDelete(id);
	}
}

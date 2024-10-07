package com.ss.thymybatis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ss.thymybatis.dto.Comment;
import com.ss.thymybatis.service.ArticleService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class ArticleRestController {
	@Autowired
	private ArticleService service;

	// 기본매핑을 할때는 수정을 한다.
	// method="patch"
	@PatchMapping("/comment/{id}")
	public ResponseEntity<Comment> commentUpdate(@PathVariable int id, Comment comment) {
		log.info("restcontroller comment() 실행");
		log.info("" + id);
		log.info("" + comment);
		log.info("id:{} com:{}", id, comment.toString());

		int updated = service.commentUpdate(comment);
		
		Comment resultComment = null;
		if (updated > 0) {
			resultComment = service.updateNew(id);
		}

		return resultComment != null ? ResponseEntity.status(HttpStatus.OK).body(resultComment)
				: ResponseEntity
						// 상태에서 에러가 났기 때문에 돌려줄 값이 없다!
						.status(HttpStatus.BAD_REQUEST).build(); // 비었다.
	}

	// 댓글 삭제를 요청하는 mapping
	// method="delete"
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Comment> commentDelete(@PathVariable int id, Comment comment) {
		log.info("restcontroller commentDelete() 실행");
		log.info("" + id);
		log.info("id:{} ", id);

		Comment deleted = service.commentDelete(id);

		return deleted != null ? ResponseEntity.status(HttpStatus.NO_CONTENT).build()
				: ResponseEntity
						// 상태에서 에러가 났기 때문에 돌려줄 값이 없다!
						.status(HttpStatus.BAD_REQUEST).build(); // 비었다.
	}
}

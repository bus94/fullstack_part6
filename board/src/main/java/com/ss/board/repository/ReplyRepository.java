package com.ss.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ss.board.entity.Reply;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long>{

	List<Reply> findByBoardNoAndWriterNo(Long no, Long writerNo);
	// 특정 게시글 번호, 그 번호에 해당하는 댓글을 조회해서 페이징 처리를 해서 보내기
	// 특정 쿼리 메서드 생성!
	
}

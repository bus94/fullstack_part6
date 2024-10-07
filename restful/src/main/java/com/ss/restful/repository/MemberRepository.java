package com.ss.restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ss.restful.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Integer>{
	// 1. 아이디로 회원 조회
	public Member findById(String id);
	// 2. 이메일로 회원 조회
	public Member findByEmail(String email);
	// 3. 이름으로 회원 조회
	public List<Member> findByName(String name);
	// 4. 성별으로 회원 조회
	public List<Member> findByGender(String gender);
	// 5. 특정 취미가 있는 회원 조회
	public List<Member> findByHobbyContaining(String hobby);
	// 6. 나이로 회원 조회(25세 이상)
	//    모든 나이를 조회
	public List<Member> findByAgeGreaterThanEqual(Integer age);
	public List<Member> findByAge();
}

/*
 * JPA 메서드 작성할 때 유의점
 * - 반드시 엔티티 클래스에 정의된 필드와 일치해야된다.
 * - 필드 이름을 잘못 작성하면 JPA쿼리를 자동으로 생성하지 못한다.
 * - 지원하는 키워드 말고는 사용 못한다.
 * - and, or의 순서를 잘 작성해야한다. (뒤죽박죽x)
 * 		ex) List<Member> findByAgeAndNameOrEmailGreaterThanEqual(Integer age, String name, String email); 
 * 	해결!	=>  List<Member> findByAgeGreaterThanEqualAndNameOrEmail(Integer age, String name, String email); 라는 식의 순서를 조건에 맞게 잘 작성해야한다!
 * - 너무 길게 조건을 줄 경우
 * 		ex) List<Member> findByFirstNameAndLastNameAndAgeGreaterThanAndStatusAndJoinedDateBetween(String firstName, String lastName, Integer age, String status, LocalDate startDate, LocalDate endDate);
 * 	해결!	=>  @Query("SELECT m FROM Member m WHERE m.firstName = :firstName AND m.lastName = :lastName AND m.age > :age AND m.status = :status AND m.joinedDate BETWEEN :startDate AND :endDate")
	쿼리로!	List<Member> findMembers(@Param("firstName") String firstName, @Param("lastName") String lastName, @Param("age") Integer age, @Param("status") String status,  @Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
 */
	
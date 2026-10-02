package com.tenco.spring_blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 영속성 컨텍스트 활용한 Repository 클래스 만들기
 * Repository 란
 * "저장소", "보관소" "창고" 를 의미한다.
 * 즉, 소프트웨어에서는 데이터를 저장하고 관리하는 곳을 추상화한 개념입니다.
 */

@RequiredArgsConstructor // final 필드 초기화 처리
@Repository // IoC + 싱글톤
public class BoardPersistRepository {


}








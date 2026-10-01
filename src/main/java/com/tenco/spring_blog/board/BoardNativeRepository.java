package com.tenco.spring_blog.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// final 필드에 대한 생성자를 .class 생성시 자동으로 생성
@RequiredArgsConstructor  // DI 처리
@Repository // IoC, @Repository : 스프링이 데이터 접근 계층으로 인식, 데이터베이스 예외를 스프링 예외로 변환해 줌
public class BoardNativeRepository {

}

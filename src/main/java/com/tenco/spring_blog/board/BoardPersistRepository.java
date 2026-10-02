package com.tenco.spring_blog.board;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

/**
 * 영속성 컨텍스트 활용한 Repository 클래스 만들기
 * Repository 란
 * "저장소", "보관소" "창고" 를 의미한다.
 * 즉, 소프트웨어에서는 데이터를 저장하고 관리하는 곳을 추상화한 개념입니다.
 */

@RequiredArgsConstructor // final 필드 초기화 처리
@Repository // IoC + 싱글톤
public class BoardPersistRepository {

    private final EntityManager em;

    // 게시글 저장 기능
    @Transactional
    public Board save(Board board) {
        // 1. 매개변수로 받은 board는 이시점에서 비영속 상태라고 할 수 있다.
        //    - 아직 영속성 컨텍스트에 관리되지 않은 상태
        //    - 데이터베이스와 연관 없는 순수 Java 객체인 상태

        em.persist(board);
        // 2.  em.persist(board); 이후에 엔티티를 영속성 컨텍스트에 저장 시킴
        //     - board 객체가 영속 상태로 변경됨
        //     - 영속성 컨텍스트가 엔티티를 관리하기 시작 함.
        //     - 아직 실제 INSERT 쿼리는 실행되지 않음 (쓰기 지연)

        // 3. 트랜잭션 커밋 시점에 실제 INSERT 쿼리 실행 됨
        //    - 이때 영속성 컨텍스트의 변경 사항이 DB 에 반영됨
        //    - board 객체의 id 필드에 자동 생성된 값이 할당 됨.
        return board;
        // 4. 영속 상태의 객체를 반환
        //    - 자동으로 생성된 id 값을 포함한 객체가 반환 됨.
    }

    // 엔티티의 영속 상태 4가지
    // 1. 비영속 상태 : 새로 생성된 객체, 영속성 컨텍스트와 무관
    // 2. 영속   상태 : 영속성 컨텍스트의 관리되는 상태
    // 3. 준 영속 상태 : 영속성 컨텍스트에서 분리된 상태
    // 4. 삭제   상태 : 삭제 예정 상태 (트랜잭션 커밋 시 DELETE 쿼리 실행)
    private void entityLifecycleEx() {
        // 1. 비영속
        Board board = new Board("제목", "내용", "작성자");

        // 2. 영속
        em.persist(board);

        // 3. 준 영속 : 영속성 컨텍스트에서 분리된 상태
        em.detach(board);

        // 5. 삭제 : 삭제 예정 상태
        em.remove(board);
    }
}








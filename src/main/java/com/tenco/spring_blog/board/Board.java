package com.tenco.spring_blog.board;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
// 엔티티 클래스 만들기 : 데이터베이스 테이블 한 개를 자바 클래스로 그린 설계도
@Table(name = "board_tb")
@Entity
public class Board {

}

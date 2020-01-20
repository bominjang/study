package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor //기본생성자
@Entity //==table 매칭. table명과 변수 명이 같으면 굳이 매칭 안해줘도 됨.
@Data
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//어떤식으로 관리할건지!
    private Long id;

    //@Column(name = "account") 컬럼과 변수의 명이 다를 때 이걸 씀.
    private String account;

    private String email;

    private String phoneNumber; //java에서는 camelcase, db에서는 snake case
    //이러한 변수 차이점을 jpa에서 지원해줌.

    private LocalDateTime createdAt;

    private String createdBy;

    private LocalDateTime updatedAt;

    private String updatedBy;

    //user는 1이지만 orderDetail은 N이다.
    //fetch type과 mapping할 변수를 각각 지정한다.
    //여기서는 OrderDetail이라는 클래스 안에, user 변수와 매핑시키겠다! 라고 선언한 것.
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderDetail> orderDetailList;
}

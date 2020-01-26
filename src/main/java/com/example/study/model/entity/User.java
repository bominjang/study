package com.example.study.model.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor //기본생성자
@Entity //==table 매칭. table명과 변수 명이 같으면 굳이 매칭 안해줘도 됨.
@Data
@AllArgsConstructor
@ToString(exclude = {"orderGroup"})
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//어떤식으로 관리할건지!
    private Long id;

    //@Column(name = "account") 컬럼과 변수의 명이 다를 때 이걸 씀.
    private String account;

    private String password;

    private String status;

    private String email;

    private String phoneNumber; //java에서는 camelcase, db에서는 snake case
    //이러한 변수 차이점을 jpa에서 지원해줌.

    private LocalDateTime registeredAt;

    private LocalDateTime unregisteredAt;

    @CreatedDate
    private LocalDateTime createdAt;

    @CreatedBy
    private String createdBy;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    @LastModifiedBy
    private String updatedBy;

    //user Entity 입장에서는, user는 한개이지만, OrderGroup은 여러개 가질 수 있음
    //따라서 User 1: N Group

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<OrderGroup> orderGroupList;
}

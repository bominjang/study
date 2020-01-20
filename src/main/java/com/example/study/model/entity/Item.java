package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer price;

    private String content;

    //1:N

    //fetch Type : LAZY = 지연 로딩 ,EAGER = 즉시 로딩

    //LAZY  = SELECT * FROM item id = ? 형식의 쿼리를 날림
    //즉, 우리가 선택한 id에 대해서만 결과를 가져옴.
    //변수에 대한 메소드를 호출하지 않는 이상, 연관관계가 설정된 테이블에 대해 select를 하지 않겠다.

    //EAGER = 즉시 모든 것을 다 로딩하겠다. >> 성능 저하가 있을 수 있음.
    //보통 1:1 관계에서 쓰는 것을 추천함.
    // item_id = order_detail.item_id
    // user_id = order_detail.user_id
    // where item.id = ?
    //연관관계가 설정된 모든 테이블에 대해 join이 일어남.
    //join order_detail orderdetai1_ on item0_.id=orderdetai1_.item_id left outer join user user2_ on orderdetai1_.user_id=user2_.id where item0_.id=?
    @OneToMany(fetch = FetchType.EAGER,mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}

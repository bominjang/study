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

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "item")
    private List<OrderDetail> orderDetailList;
}

package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
//Lombok을 쓰면, ToString을 자동으로 만들어주게 되는데,지금 Orderdetail과 User가 서로 상호 참조를 하고 있음.
//그렇기 때문에 exclude를 통해 빼준다..?!(공부하기)
@ToString(exclude = {"user","item"})
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderAt;

    //order detail입장에서는 자신은 N이고 user는 1임.
    //따라서 N : 1
    @ManyToOne
    //Hibernate를 통한 객체 맵핑을 하려면 무조건 객체 타입으로 변수 선언을 해줘야 함.
    private User user; //알아서 user_id를 찾아갈 것!

    //N:1
    @ManyToOne
    private Item item;

}

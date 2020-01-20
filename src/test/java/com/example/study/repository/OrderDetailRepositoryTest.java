package com.example.study.repository;

import com.example.study.StudyApplication;
import com.example.study.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class OrderDetailRepositoryTest{
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderAt(LocalDateTime.now());

        //어떤 사람에 대한 index id
        //orderDetail.setUserId(4L);


        //어떤 상품에 대한 index id
        //orderDetail.setItem(1L);

        //index id 4번에 해당하는 사람이 index id 1에 해당하는 상품을 구매했다.

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }
}

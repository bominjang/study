package com.example.study.repository;

import com.example.study.StudyApplication;
import com.example.study.model.entity.OrderDetail;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class OrderDetailRepositoryTest extends StudyApplication {
    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Test
    public void create(){
        OrderDetail orderDetail = new OrderDetail();

        orderDetail.setOrderAt(LocalDateTime.now());

        //어떤 사람에 대한 index id
        orderDetail.setUserId(4L);


        //어떤 상품에 대한 index id
        orderDetail.setItemId(1L);

        //index id 4번에 해당하는 사람이 index id 1에 해당하는 상품을 구매했다.

        OrderDetail newOrderDetail = orderDetailRepository.save(orderDetail);
        Assert.assertNotNull(newOrderDetail);
    }
}

package com.example.study.repository;

import com.example.study.model.entity.Partner;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.Part;
import java.time.LocalDateTime;

@SpringBootTest
public class PartnerRepositoryTest {
    @Autowired
    private PartnerRepository partnerRepository;

    //우리가 사용하고자 하는 repo가 column과 잘 매칭되는지만 확인
    @Test
    public void create(){
        String name = "Partner01";
        String status = "REGISTERED";
        String address = "서울시 강남구";
        String callCenter = "070-1111-2222";
        String partnerNumber = "010-1111-2222";
        String businessNumber = "1234567890123";
        String ceoName = "홍길동";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";
        Long categoryId = 1L;

        Partner partner = new Partner();
        partner.setName(name);
        partner.setStatus(status);
        partner.setAddress(address);
        partner.setCallCenter(callCenter);
        partner.setPartnerNumber(partnerNumber);
        partner.setBusinessNumber(businessNumber);
        partner.setCeoName(ceoName);
        partner.setRegisteredAt(registeredAt);
        partner.setCreatedAt(createdAt);
        partner.setCreatedBy(createdBy);
        //partner.setCategoryId(categoryId);

        Partner newPartner = partnerRepository.save(partner);
        Assert.assertNotNull(newPartner);
        Assert.assertEquals(newPartner.getName(),name);

    }

}

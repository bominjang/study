package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
//기본 키에 대해 어떤 값이 드러있는 지, User라는 entity에 기본 키 id값은 Long타입으로 지정.
public interface UserRepository extends JpaRepository<User, Long> {

    //findFirstBy = 같은 값으로 여러명이 가입을 할 수 있기 때문에, 같은 검색 값에 대해서 가장 최근의 것이
    //반환됨.
    User findFirstByPhoneNumberOrderByIdDesc(String phoneNumber);



}

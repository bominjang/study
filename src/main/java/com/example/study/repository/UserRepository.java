package com.example.study.repository;

import com.example.study.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//기본 키에 대해 어떤 값이 드러있는 지, User라는 entity에 기본 키 id값은 Long타입으로 지정.
public interface UserRepository extends JpaRepository<User, Long> {
}

package com.example.study.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.Item;
import com.example.study.model.entity.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;
//jpa에서의 entity는 db의 table과 동일하다고 보면 됨.
//@table : 실제 db테이블의 이름을 명시
//@column : 실제 db의 comlumn이름을 명시
public class UserRepositoryTest extends StudyApplicationTests {
    @Autowired //DI라고 하는 것. dependency injection. 직접 객체를 만들지 않고,
    //스프링이 만들어서 그것을 관리하는 것.
    //Autowired라는 것을 통해서 주입하는 것.
    private UserRepository userRepository;

    @Test
    public void create(){

        String account = "Test01";
        String password = "Test01";
        String status = "REGISTERED";
        String email = "Test01@gmail.com";
        String phoneNumber = "010-1111-2222";
        LocalDateTime registeredAt = LocalDateTime.now();
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        User user = new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setStatus(status);
        user.setEmail(email);
        user.setPhoneNumber(phoneNumber);
        user.setRegisteredAt(registeredAt);
        user.setCreatedAt(createdAt);
        user.setCreatedBy(createdBy);

        User newUser = userRepository.save(user);

        Assert.assertNotNull(newUser);


    }

    @Test
    @Transactional
    public void read(){

        User user = userRepository.findFirstByPhoneNumberOrderByIdDesc("010-1111-2222");
        Assert.assertNotNull(user);

    }

    @Test
    @Transactional //확인되지 않은 Exception 발생 시 RollBack 하도록 !
    public void update(){
        //업데이트를 하기 위해서는 특정 User를 Select 해야함.
        Optional<User> user = userRepository.findById(2L);

        user.ifPresent(selectUser ->{
           selectUser.setAccount("PPPP");
           selectUser.setUpdatedAt(java.time.LocalDateTime.now());
           selectUser.setUpdatedBy("update method()");

           userRepository.save(selectUser);
        });

    }

    @Test
    @Transactional //확인되지 않은 Exception 발생 시 RollBack 하도록 !
    public void delete(){
        Optional<User> user = userRepository.findById(3L);

        Assert.assertTrue(user.isPresent()); //True 여야 함.
        user.ifPresent(selectUser ->{
          userRepository.delete(selectUser);
        });

        Optional<User> deleteUser = userRepository.findById(3L);

        Assert.assertFalse(deleteUser.isPresent()); //반드시 false여야 함.
    }


}

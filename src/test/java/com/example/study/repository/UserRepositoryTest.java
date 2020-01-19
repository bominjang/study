package com.example.study.repository;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.example.study.StudyApplicationTests;
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
    private Object LocalDateTime;

    @Test
    public void create(){
        //String sql = insert into user(%s, %s, %d) value (account, email, age)
        //이런식으로 쿼리문을 가지고 했었는데, JPA는 object를 통해 관리함.
       //DI의 기본 핵심 : single tone
        //유저는 하나만 생성해서 autowired에 다같이 쓰겠다!
        User user = new User();
        //user.setId(); setId는 db에서 autoincreament이기 때문에 자동으로 올라가는 것임.
        //이렇게 해줄 필요 없음.
        user.setAccount("TestUser03");
        user.setEmail("TestUser03@gmail.com");
        user.setPhoneNumber("010-1111-3333");
        user.setCreatedAt(java.time.LocalDateTime.now());
        user.setCreatedBy("TestUser03");

        User newUser = userRepository.save(user);
        System.out.println("newUser"+newUser);

    }

    @Test
    public void read(){
        //findAll : db에 있는 User table을 list로 모두 가져오겠다.
        //findById : 한 건을 select
        Optional<User> user = userRepository.findById(2L);
        //있을 수 도 있고 없을 수도 있을 때!
        //다음은, Optional 에 대한 결과가 존재할 때 수행.
        user.ifPresent(selectUser ->{
            System.out.println("user : "+selectUser);
            System.out.println("email : "+selectUser.getEmail());
        });
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

package com.example.study.repository;

import com.example.study.StudyApplicationTests;
import com.example.study.model.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
        user.setAccount("TestUser01");
        user.setEmail("TestUser01@gmail.com");
        user.setPhoneNumber("010-1111-2222");
        user.setCreatedAt((java.time.LocalDateTime) LocalDateTime);
        user.setCreatedBy("admin");

        User newUser = userRepository.save(user);
        System.out.println("newUser"+newUser);

    }

    public void read(){}

    public void use(){}

    public void update(){

    }


}

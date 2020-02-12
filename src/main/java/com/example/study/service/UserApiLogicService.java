package com.example.study.service;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.entity.User;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

//해당 java project가 service로 동작할 수 있도록!
@Service
public class UserApiLogicService implements CrudInterface<UserApiRequest, UserApiResponse> {

    //Repository import!
    @Autowired
    private UserRepository userRepository;

    //1. request data 가져오기
    //2. user 생성
    //3. 생성된 데이터 -> UserApiResponse return
    @Override
    public Header<UserApiResponse> create(Header<UserApiRequest> request) {

        //1.requeset data
        //data 부분에 있는 apiRequest를 가져옴.
        UserApiRequest userApiRequest = request.getData();

        //2. User 생성 - client 단에서 받은 정보로 User 객체 생성
        User user = User.builder()
                .account(userApiRequest.getAccount())
                .password(userApiRequest.getPassword())
                .status("REGISTERED")
                .phoneNumber(userApiRequest.getPhoneNumber())
                .email(userApiRequest.getEmail())
                .registeredAt(LocalDateTime.now())
                .build();
        User newUser = userRepository.save(user);

        //3. 생성된 데이터 -> userApiResponse return
        //이것은 read나 update 등 다른 메소드에서도 사용할 수 있으니,따로 메소드로 빼자!

        return response(newUser);

    }

    @Override
    public Header<UserApiResponse> read(Long id) {
        return null;
    }

    @Override
    public Header<UserApiResponse> update(Header<UserApiRequest> request) {
        return null;
    }

    @Override
    public Header<UserApiResponse> delete(Long id) {
        return null;
    }

    private Header<UserApiResponse> response(User user){
        //user 객체를 받아서 userApiResponse를 만들어서 내보내는 메소드!
        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword()) // todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        //Header + data return
        return Header.OK(userApiResponse);
    }
}

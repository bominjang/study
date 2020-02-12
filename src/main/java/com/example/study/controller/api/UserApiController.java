package com.example.study.controller.api;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import com.example.study.model.network.request.UserApiRequest;
import com.example.study.model.network.response.UserApiResponse;
import com.example.study.service.UserApiLogicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@Slf4j //로깅을 남기기 위한 annotation
@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface<UserApiRequest, UserApiResponse> {

    @Autowired
    private UserApiLogicService userApiLogicService;


    @Override
    @PostMapping("") //api/user로 매핑
    public Header<UserApiResponse> create(@RequestBody Header<UserApiRequest> request) {
        //디버깅할 때, 로깅을 남기면 훨씬 쉬움.
        log.info("{}",request); // -> request.toString() 식으로 파일에 로그가 남게 됨.
        return userApiLogicService.create(request);
    }

    @Override
    @GetMapping("{id}") //api/user/해당id로 매핑
    public Header<UserApiResponse> read(@PathVariable(name = "id") Long id) {
        return null;
    }

    @Override
    @PutMapping("") //api/user
    public Header<UserApiResponse> update(@RequestBody Header<UserApiRequest> request) {
        return null;
    }

    @Override
    @DeleteMapping("{id}") //api/user/id
    public Header<UserApiResponse> delete(@PathVariable(name = "id")Long id) {
        return null;
    }
}

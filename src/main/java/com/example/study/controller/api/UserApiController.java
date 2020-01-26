package com.example.study.controller.api;

import com.example.study.ifs.CrudInterface;
import com.example.study.model.network.Header;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserApiController implements CrudInterface {


    @Override
    @PostMapping("") //api/user로 매핑
    public Header create() {
        return null;
    }

    @Override
    @GetMapping("{id}") //api/user/해당id로 매핑
    public Header read(Long id) {
        return null;
    }

    @Override
    @PutMapping("") //api/user
    public Header update() {
        return null;
    }

    @Override
    @DeleteMapping("{id}") //api/user/id
    public Header delete() {
        return null;
    }
}

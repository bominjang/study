package com.example.study.ifs;

import com.example.study.model.network.Header;

public interface CrudInterface {

    //todo request object 추가

    Header create();

    Header read(Long id);

    Header update();

    Header delete();


}

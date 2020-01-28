package com.example.study.ifs;

import com.example.study.model.network.Header;

//Generic type으로 선언하게 되면, 모든 컨트롤러가 동일한 인터페이스를 상속받을 수 있음!
public interface CrudInterface<Req, Res> {

    //todo request object 추가

    Header<Res> create(Header<Req> request);

    Header<Res> read(Long id);

    Header<Res> update(Header<Req> request);

    Header<Res> delete(Long id);


}

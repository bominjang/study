package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

@RestController
//같은 클래스 내에서 같은 메소드에 대해서 같은 주소가 매핑되면 메소드는 실행되지 못한다!
//하지만 다른 클래스에 대해서는 Request매핑의 주소가 겹치더라도 괜찮음
@RequestMapping("/api")
public class PostController {

    //Post는 HTML의 <Form>를 사용한다던지,
    //ajax에서 검색을 할 때 사용됨.
    //form태그의 검색에 사용된다는 말은, 검색 파라미터가 아주 많다는 것을 뜻함!

    //http 통신을 할 때 post의 body 안에 data를 집어넣어서 보내겠다!
    //그래서 받을 때 RequestBody에 SearchParam를 요청시켜서 주세요~라는 것을 인자에 넣음.

    //Request의 form은 여러가지가 있음.
    //json, xml, multipart-form / text-plain 등
    //여러가지들을 다 지원할 수 없기 때문에 필요한 걸 설정해줌.
    @PostMapping(value = "/postMethod")
    //기본적으로 json사용하기 때문에 ,produces = {"application-json"}은 사실 써줄 필요가 없음.

    // 파라미터로 @ReauesetBody를 통해 파라미터가 json으로 올거야!
    // 헤더값을 보고 어플리케이션 제이슨을 확인하고 RequestBody 즉, 전달받은 json값들을
    //searchParam이라는  객체에 가서 account는 account에, email은 email에, page는 page에 json형태로 바꾼다음에 return시켜줌
    public SearchParam postMethod(@RequestBody SearchParam searchParam){
        return searchParam;
    }

    //PUT,Patch,delete 구현하기
    /*
    @PutMapping("/putMethod")
    public void put(){}

    @PatchMapping("/patchMethod")
    public void patch(){}

    @DeleteMapping("")
    public void delete(){}
    */
}


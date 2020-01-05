package com.example.study.controller;

import com.example.study.model.SearchParam;
import org.springframework.web.bind.annotation.*;

//이것은 컨트롤러로 활용할거야!
@RestController
//이곳으로 들어올 API주소를 매핑
@RequestMapping("/api") //Localhost:8080/api 까지 주소가 매핑된 것

public class GetController {
    //method는 어떠한 방식으로 받고, path는 어떠한 주소로 받아들일 지 설정
    @RequestMapping(method = RequestMethod.GET,path= "/getMethod")
    //LocalHost:8080/api/getMethod라는 주소로 호출하게 되면 사용자의 요청이
    //이 메소드로 들어옴.
    //getMethod는 사용자가 요청하는 주소를 처리해야함.
    public String getMethod(){
        return "Hi getMethod";
    }
    //GetMapping annotation은 메소드를 지정하지 않아도 되고, 주소만 설정해주면 됨.
    @GetMapping("/getParameter") //localhost:8080/api/getParameter라는 주소로 매핑됨.
    //GET메소드는 ?로부터 파라미터가 시작되는데 localhost:8080/api/getParameter?id=1234&password=abcd의 형태로 파라미터가 전달됨.
    //그러면 스프링에서 이것을 처리하기 위해 @RequestParam이라는 annotation을 설정해줌.
    public String getParameter(@RequestParam String id, @RequestParam(name = "passwd") String pwd){
        String passwd = "bbbb";

        System.out.println("id: "+id);
        System.out.println("pwd: "+pwd);

        return id+pwd;
    }
    //전달되는 파라미터가 계속 늘어나는 상황에는 ?!
    //localhost:8080/api/multiParameter?account=abcd&email=study@gamil.com&page=10
    //RequestParam@ 을 쓰기에는 너무 파라미터가 많아짐. -> 객체로 받자!

  //  @GetMapping("/getMultiParameter") //주소 지정정
   /*
    public SearchParam getMultiParameter(SearchParam searchParam){
        //해당 값 잘 들어왔는 지 확인
        System.out.println(searchParam.getAccount());
        System.out.println(searchParam.getEmail());
        System.out.println(searchParam.getPage());

        //네트워크 통신을 할 때, json형식으로 통신을 하길 원함(아래와 같이)
        //{"account" : "", "email": "", "page":0}
        //그러기위해선 return 값을 serchParam으로 바꿔주면 됨(원래는 String이었음)
        //객체에서는 기본적으로 jackson을 내장하고 있기 때문!

       return searchParam;

    }

    */
}

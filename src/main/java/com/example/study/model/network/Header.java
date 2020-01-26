package com.example.study.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Header부분에, data부분을 어떠한 generic으로 생성할 지 언급!
public class Header<T> {

    //api 통신 시간
    private String transactionTime;


    //api 응답 코드
    private String resultCode;

    //api 부가 설명
    private String description;

    //해당 generic으로 data부분 생성
    private T data;
}

